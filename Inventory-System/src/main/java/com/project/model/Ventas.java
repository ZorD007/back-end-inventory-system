package com.project.model;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Sucursal sucursal;
}
