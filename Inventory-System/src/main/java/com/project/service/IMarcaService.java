package com.project.service;

import com.project.dto.ReqDtoMarca;
import com.project.dto.ResponseDtoMarca;
import com.project.model.Marca;

public interface IMarcaService {
    ResponseDtoMarca agregarMarca(ReqDtoMarca reqDtoMarca) throws Exception;
    boolean eliminarMarca(Long id) throws Exception;
}
