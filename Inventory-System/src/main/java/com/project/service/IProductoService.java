package com.project.service;

import com.project.dto.ReqDtoProducto;
import com.project.dto.ResponseDtoProducto;

public interface IProductoService {
    ResponseDtoProducto agregarProducto(ReqDtoProducto reqDtoProducto) throws Exception;
}
