package it.orbyta.backend_test_cert.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDto {

    private String nome;
    private String descrizione;
    private String foto;

}
