package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "producto_has_sucursal")
public class ProductoSucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productosucursal")
    private Long idProductoSucursal;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false, updatable = false)
    private Sucursal sucursal;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false, updatable = false)
    private Producto producto;
}
