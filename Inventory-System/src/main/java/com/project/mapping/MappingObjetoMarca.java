package com.project.mapping;

import com.project.dto.ReqDtoMarca;
import com.project.model.Marca;

public class MappingObjetoMarca {
    public Marca transformDtoToModel(ReqDtoMarca reqDtoMarca) throws Exception {
        Marca marcaLocal;
        try{
            marcaLocal = new Marca();
            marcaLocal.setIdMarca(reqDtoMarca.getIdMarcaDto());
            marcaLocal.setNombreMarca((reqDtoMarca.getNombreMarcaDto()));

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();

        }
        return marcaLocal;
    }
}
