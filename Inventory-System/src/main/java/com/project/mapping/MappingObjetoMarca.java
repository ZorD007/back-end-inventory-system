package com.project.mapping;

import com.project.dto.ReqDtoMarca;
import com.project.dto.ResponseDtoMarca;
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

    public ResponseDtoMarca transformModelaResponse(Marca marca) throws Exception{
            ResponseDtoMarca responseDtoMarca;
        try{
            responseDtoMarca = new ResponseDtoMarca();
            responseDtoMarca.setMarcaDto(marca.getNombreMarca());

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return responseDtoMarca;
    }
}
