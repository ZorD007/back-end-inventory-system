package com.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombreUsuario;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passwordUsuario;

    @Column(name = "last_login")
    private Date ultimaFecha;
}
