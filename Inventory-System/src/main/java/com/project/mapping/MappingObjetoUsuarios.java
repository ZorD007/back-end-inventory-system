package com.project.mapping;

import com.project.dto.ReqDtoUsuarios;
import com.project.model.Usuarios;

public class MappingObjetoUsuarios {

    public Usuarios transformDtoToModel(ReqDtoUsuarios reqDtoUsuarios) throws Exception {
        Usuarios usuariosLocal;
        try {
            usuariosLocal = new Usuarios();
            usuariosLocal.setIdUsuario(reqDtoUsuarios.getIdUsuarioDto());

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();

        }
        return usuariosLocal;
    }
}
