package com.project.service;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVentas2;
import com.project.dto.ResponseDtoVentas;
import com.project.model.Ventas;

import java.util.Date;
import java.util.List;

public interface IVentasService {
    List<Ventas> reporteDeGanancias(Date fechaInicio, Date fechaFin) throws Exception;
    Ventas venderProductos(ReqDtoVentas reqDtoVentas) throws Exception;
    List<ResponseDtoVentas> mostrarVenta(ReqDtoVentas2 reqDtoVentas2) throws Exception;
}
