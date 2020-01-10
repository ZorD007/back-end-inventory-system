package com.project.dto;

import com.project.model.Producto;

import java.util.Date;

public class ResponseDtoVentas {
    private String nombreVendedorDto;
    private Date fechaDto;
    private Producto productoDto;
    private int cantidadVendidoDto;
    private int ventaTotalDto;
    private String sucursalDto;

    public String getNombreVendedorDto() {
        return nombreVendedorDto;
    }

    public void setNombreVendedorDto(String nombreVendedorDto) {
        this.nombreVendedorDto = nombreVendedorDto;
    }

    public Date getFechaDto() {
        return fechaDto;
    }

    public void setFechaDto(Date fechaDto) {
        this.fechaDto = fechaDto;
    }

    public Producto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(Producto productoDto) {
        this.productoDto = productoDto;
    }

    public int getCantidadVendidoDto() {
        return cantidadVendidoDto;
    }

    public void setCantidadVendidoDto(int cantidadVendidoDto) {
        this.cantidadVendidoDto = cantidadVendidoDto;
    }

    public int getVentaTotalDto() {
        return ventaTotalDto;
    }

    public void setVentaTotalDto(int ventaTotalDto) {
        this.ventaTotalDto = ventaTotalDto;
    }

    public String getSucursalDto() {
        return sucursalDto;
    }

    public void setSucursalDto(String sucursalDto) {
        this.sucursalDto = sucursalDto;
    }
}
