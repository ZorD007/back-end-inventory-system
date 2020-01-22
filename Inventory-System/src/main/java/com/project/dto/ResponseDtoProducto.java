package com.project.dto;

import java.util.Date;

public class ResponseDtoProducto {

    private Long idProductoDto;
    private String modeloDto;
    private String sistemaOperativoDto;
    private String marcaDto;
    private int precioCompraDto;
    private int precioVentaDto;
    private Date fechaProductoDto;
    private int cantidadDto;


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

    public String getMarcaDto() {
        return marcaDto;
    }

    public void setMarcaDto(String marcaDto) {
        this.marcaDto = marcaDto;
    }

    public int getPrecioCompraDto() {
        return precioCompraDto;
    }

    public void setPrecioCompraDto(int precioCompraDto) {
        this.precioCompraDto = precioCompraDto;
    }

    public int getPrecioVentaDto() {
        return precioVentaDto;
    }

    public void setPrecioVentaDto(int precioVentaDto) {
        this.precioVentaDto = precioVentaDto;
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

}
