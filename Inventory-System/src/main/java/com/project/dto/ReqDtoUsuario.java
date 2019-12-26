package com.project.dto;

import java.util.Date;

public class ReqDtoUsuario {
    private Long idUsuarioDto;
    private String nombreDto;
    private String userNameDto;
    private String passwordDto;
    private Date fechaDto;


    public Long getIdUsuarioDto() {
        return idUsuarioDto;
    }

    public void setIdUsuarioDto(Long idUsuarioDto) {
        this.idUsuarioDto = idUsuarioDto;
    }

    public String getNombreDto() {
        return nombreDto;
    }

    public void setNombreDto(String nombreDto) {
        this.nombreDto = nombreDto;
    }

    public String getUserNameDto() {
        return userNameDto;
    }

    public void setUserNameDto(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

    public Date getFechaDto() {
        return fechaDto;
    }

    public void setFechaDto(Date fechaDto) {
        this.fechaDto = fechaDto;
    }
}
