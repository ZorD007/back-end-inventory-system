package com.project.service;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ReqDtoUsuarioLogin;
import com.project.dto.ResponseDtoUsuario;

public interface IUsuariosService {

    ResponseDtoUsuario registrarUsuario(ReqDtoUsuario reqDtoUsuario) throws Exception;
    boolean validarSesion(ReqDtoUsuarioLogin reqDtoUsuario) throws Exception;

}
