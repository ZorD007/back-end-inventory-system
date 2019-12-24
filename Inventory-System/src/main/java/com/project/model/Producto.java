package com.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "sistema_operativo", nullable = false)
    private String sistemaOperativo;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "fecha", nullable = false)
    private Date fechaProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Marca marca;
}
