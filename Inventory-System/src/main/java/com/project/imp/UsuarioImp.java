package com.project.imp;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ResponseDtoUsuario;
import com.project.mapping.MappingObjetoUsuarios;
import com.project.model.Rol;
import com.project.model.Usuario;
import com.project.repository.UsuarioRepository;
import com.project.service.IPbkdf2EncryptService;
import com.project.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImp implements IUsuariosService {

    @Autowired
    private UsuarioRepository usuariosRepository;

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
            if (null == validarUserName){
                usuario = new Usuario();
                usuario.setNombreUsuario(reqDtoUsuario.getNombreDto());
                usuario.setUserName(reqDtoUsuario.getUserNameDto());
                usuario.setPasswordUsuario(iPbkdf2EncryptService.generarHashPassword(reqDtoUsuario.getPasswordDto()));


            }

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return null;
    }

    @Override
    public boolean validarSesion(ReqDtoUsuario reqDtoLogin) throws Exception {
        return false;
    }
}
