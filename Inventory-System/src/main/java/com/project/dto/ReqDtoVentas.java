package com.project.dto;

import java.util.Date;

public class ReqDtoVentas {
    private Date rangoFechaDto;
    private String vendedorDto;

    public Date getRangoFechaDto() {
        return rangoFechaDto;
    }

    public void setRangoFechaDto(Date rangoFechaDto) {
        this.rangoFechaDto = rangoFechaDto;
    }

    public String getVendedorDto() {
        return vendedorDto;
    }

    public void setVendedorDto(String vendedorDto) {
        this.vendedorDto = vendedorDto;
    }
}
