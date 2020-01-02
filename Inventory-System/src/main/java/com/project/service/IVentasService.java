package com.project.service;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ResponseDtoVentas;
import com.project.model.Ventas;

import java.util.Date;

public interface IVentasService {
    Ventas reporteDeGanancias(Date rangoFecha) throws Exception;
    Ventas venderProductos(ReqDtoVentas reqDtoVentas) throws Exception;
    ResponseDtoVentas mostrarVenta(ReqDtoVentas reqDtoVentas) throws Exception;
}
