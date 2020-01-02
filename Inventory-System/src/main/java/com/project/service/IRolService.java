package com.project.service;

import com.project.dto.ReqDtoRol;
import com.project.dto.ResponseDtoRol;
import com.project.model.Rol;

public interface IRolService {
    ResponseDtoRol añadirRol(ReqDtoRol reqDtoRol) throws  Exception;
    Rol buscarPorId(Long id) throws Exception;
}
