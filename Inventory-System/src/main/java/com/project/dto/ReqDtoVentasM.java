package com.project.dto;

import java.util.Date;

public class ReqDtoVentasM {

    private Date fechaVentaDto;
    private String vendedorDto;

    public Date getFechaVentaDto() {
        return fechaVentaDto;
    }

    public void setFechaVentaDto(Date fechaVentaDto) {
        this.fechaVentaDto = fechaVentaDto;
    }

    public String getVendedorDto() {
        return vendedorDto;
    }

    public void setVendedorDto(String vendedorDto) {
        this.vendedorDto = vendedorDto;
    }
}
