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

    @Column(name = "")
    private String NumeroOperacion;

    @Column(name = "fecha")
    private Date fecha;


}
