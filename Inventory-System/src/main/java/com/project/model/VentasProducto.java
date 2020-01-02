package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "ventas_has_producto")
public class VentasProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventasproductos")
    private Long idVentasProducto;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ventas", nullable = false, updatable = false)
    private Ventas ventas;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false, updatable = false)
    private Producto producto;
}
