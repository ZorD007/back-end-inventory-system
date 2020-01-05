package com.project.service;

import com.project.dto.ReqDtoProducto;
import com.project.dto.ResponseDtoProducto;
import com.project.model.Producto;

public interface IProductoService {
    ResponseDtoProducto agregarProducto(ReqDtoProducto reqDtoProducto) throws Exception;
    Producto buscarPorId(Long id) throws Exception;
    ResponseDtoProducto modificarProducto(Long id, ReqDtoProducto reqDtoProducto) throws Exception;
}
