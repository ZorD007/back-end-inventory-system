package com.project.dto;

public class ReqDtoUsuarios {
    private Long idUsuarioDto;
    private String userNameDto;
    private String passwordDto;

    public Long getIdUsuarioDto() {
        return idUsuarioDto;
    }

    public void setIdUsuarioDto(Long idUsuarioDto) {
        this.idUsuarioDto = idUsuarioDto;
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
}
