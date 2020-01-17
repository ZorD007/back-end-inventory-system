package com.project.dto;

import com.project.model.Marca;

import java.util.Date;

public class ReqDtoProducto {

    private Long idProductoDto;
    private String modeloDto;
    private String sistemaOperativoDto;
    private int precioDto;
    private Date fechaProductoDto;
    private int cantidadDto;
    private String marcaDto;

    public Long getIdProductoDto() {
        return idProductoDto;
    }

    public void setIdProductoDto(Long idProductoDto) {
        this.idProductoDto = idProductoDto;
    }

    public String getModeloDto() {
        return modeloDto;
    }

    public void setModeloDto(String modeloDto) {
        this.modeloDto = modeloDto;
    }

    public String getSistemaOperativoDto() {
        return sistemaOperativoDto;
    }

    public void setSistemaOperativoDto(String sistemaOperativoDto) {
        this.sistemaOperativoDto = sistemaOperativoDto;
    }

    public int getPrecioDto() {
        return precioDto;
    }

    public void setPrecioDto(int precioDto) {
        this.precioDto = precioDto;
    }

    public Date getFechaProductoDto() {
        return fechaProductoDto;
    }

    public void setFechaProductoDto(Date fechaProductoDto) {
        this.fechaProductoDto = fechaProductoDto;
    }

    public int getCantidadDto() {
        return cantidadDto;
    }

    public void setCantidadDto(int cantidadDto) {
        this.cantidadDto = cantidadDto;
    }

    public String getMarcaDto() {
        return marcaDto;
    }

    public void setMarcaDto(String marcaDto) {
        this.marcaDto = marcaDto;
    }
}
