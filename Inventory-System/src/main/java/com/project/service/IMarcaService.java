package com.project.service;

import com.project.dto.ReqDtoMarca;
import com.project.model.Marca;

public interface IMarcaService {
    Marca agregarMarca(ReqDtoMarca reqDtoMarca) throws Exception;
    Marca eliminarMarca() throws Exception;
}
