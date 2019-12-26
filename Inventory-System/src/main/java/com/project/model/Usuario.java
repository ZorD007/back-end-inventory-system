package com.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombreUsuario;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String passwordUsuario;

    @Column(name = "last_login")
    private Date ultimaFecha;

    @OneToOne
    @JoinColumn(name = "id_rol", updatable = false, nullable = false)
    private Rol rol;
}
