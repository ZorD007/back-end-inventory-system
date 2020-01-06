package com.project.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventas")
    private Long idVentas;

    @Column(name = "numero_operacion", nullable = false)
    private long nuOperacion;

    @Column(name = "fecha", nullable = false)
    private Date fechaVenta;

    @Column(name = "cantidad_ventas", nullable = false)
    private int cantidadVentas;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private List<VentasProducto> ventasL;

    public Long getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Long idVentas) {
        this.idVentas = idVentas;
    }

    public long getNuOperacion() {
        return nuOperacion;
    }

    public void setNuOperacion(long nuOperacion) {
        this.nuOperacion = nuOperacion;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<VentasProducto> getVentasL() {
        return ventasL;
    }

    public void setVentasL(List<VentasProducto> ventasL) {
        this.ventasL = ventasL;
    }
}
