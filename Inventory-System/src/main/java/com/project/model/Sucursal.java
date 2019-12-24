package com.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(name = "nombre_sucursal", nullable = false)
    private String nombreSucursal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private List<ProductoSucursal> sucursalProducto;
}
