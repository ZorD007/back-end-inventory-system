package com.project.mapping;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ResponseDtoUsuario;
import com.project.model.Rol;
import com.project.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class MappingObjetoUsuarios {

    public Usuario transformarDtoAUsuario(ReqDtoUsuario reqDtoUsuario, Rol rol) throws Exception {
        Usuario usuarioLocal = null;
        try{
            usuarioLocal = new Usuario();
            usuarioLocal.setIdUsuario(reqDtoUsuario.getIdUsuarioDto());
            usuarioLocal.setNombreUsuario(reqDtoUsuario.getNombreDto());
            usuarioLocal.setUserName(reqDtoUsuario.getUserNameDto());
            usuarioLocal.setPasswordUsuario(reqDtoUsuario.getPasswordDto());
            usuarioLocal.setUltimaFecha(reqDtoUsuario.getFechaDto());
            usuarioLocal.setRol(rol);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
     return usuarioLocal;
    }

    public ResponseDtoUsuario transformarUsuarioAResponse(Usuario usuarioLocal) throws Exception {
        ResponseDtoUsuario usuarioDto = null;
        try{
            usuarioDto = new ResponseDtoUsuario();
            usuarioDto.setNombreUsuarioDto(usuarioLocal.getNombreUsuario());
            usuarioDto.setUserNameDto(usuarioLocal.getUserName());
            usuarioDto.setFechaUsuarioDto(usuarioLocal.getUltimaFecha());
            usuarioDto.setTipoRolDto(usuarioLocal.getRol().getCargo());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return usuarioDto;
    }
}
