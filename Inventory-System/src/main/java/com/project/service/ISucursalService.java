package com.project.service;

import com.project.dto.ReqDtoSucursal;
import com.project.dto.ResponseDtoSucursal;
import com.project.model.Sucursal;

public interface ISucursalService {

    ResponseDtoSucursal agregarSucursal(ReqDtoSucursal reqDtoSucursal) throws Exception;
    boolean eliminarSucursal(Long id) throws Exception;
    Sucursal buscarPorId(Long id) throws Exception;
}
