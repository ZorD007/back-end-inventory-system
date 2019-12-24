package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "cargo", nullable = false, unique = true)
    private String cargo;

    @OneToOne(mappedBy = "rol", cascade = CascadeType.ALL)
    private Usuario usuario;
}
