package com.project.imp;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ResponseDtoUsuario;
import com.project.exception.NoGuardadoException;
import com.project.exception.NoValidarSesionException;
import com.project.mapping.MappingObjetoUsuarios;
import com.project.model.Rol;
import com.project.model.Usuario;
import com.project.repository.RolRepository;
import com.project.repository.UsuarioRepository;
import com.project.service.IPbkdf2EncryptService;
import com.project.service.IUsuariosService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImp implements IUsuariosService {

    @Autowired
    private UsuarioRepository usuariosRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private IPbkdf2EncryptService iPbkdf2EncryptService;

    @Autowired
    private MappingObjetoUsuarios mappingObjetoUsuarios;

    @Override
    public ResponseDtoUsuario registrarUsuario(ReqDtoUsuario reqDtoUsuario) throws Exception {
        ResponseDtoUsuario responseDtoUsuario;
        Usuario usuario;
        try {
            Usuario validarUserName = usuariosRepository.findByUserName(reqDtoUsuario.getUserNameDto());
            Rol validarRol = rolRepository.findByCargo(reqDtoUsuario.getCargoDto());
            if (validarUserName == null && validarRol != null) {
                usuario = new Usuario();
                usuario.setNombreUsuario(reqDtoUsuario.getNombreDto());
                usuario.setUserName(reqDtoUsuario.getUserNameDto());
                usuario.setPasswordUsuario(iPbkdf2EncryptService.generarHashPassword(reqDtoUsuario.getPasswordDto()));

                responseDtoUsuario = mappingObjetoUsuarios.transformarUsuarioAResponse(usuariosRepository.save(usuario));
            } else {
                throw new NoGuardadoException(Constant.ERROR_GUARDAR);
            }
        }catch (NoGuardadoException ex){
            ex.printStackTrace();
            throw new NoGuardadoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return responseDtoUsuario;
    }

    @Override
    public boolean validarSesion(ReqDtoUsuario reqDtoUsuario) throws Exception {
        Usuario usuarioLocal;
        try {
            usuarioLocal = usuariosRepository.findByUserName(reqDtoUsuario.getUserNameDto());
            if (usuarioLocal != null){
                return iPbkdf2EncryptService.validarPassword(reqDtoUsuario.getPasswordDto(), usuarioLocal.getPasswordUsuario());
            }else {
                throw new NoValidarSesionException(Constant.ERROR_VALIDAR);
            }
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            throw new NoValidarSesionException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
    }
}
