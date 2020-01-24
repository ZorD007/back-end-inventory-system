package com.project.service;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVP;
import com.project.dto.ResponseDtoVentas;
import com.project.dto.ResponseDtoVentasProducto;
import com.project.model.Ventas;

import java.util.Date;
import java.util.List;

public interface IVentasService {
    List<Ventas> reporteDeGanancias(Date fechaInicio, Date fechaFin) throws Exception;
    ResponseDtoVentasProducto venderProductos(ReqDtoVentas reqDtoVentas) throws Exception;
    List<ResponseDtoVentas> mostrarVenta(ReqDtoVP reqDtoVP) throws Exception;
}
