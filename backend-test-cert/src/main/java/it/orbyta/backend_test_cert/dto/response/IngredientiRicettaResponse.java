package it.orbyta.backend_test_cert.dto.response;

import it.orbyta.backend_test_cert.entity.Ingrediente;
import lombok.Data;

import java.util.List;
@Data
public class IngredientiRicettaResponse {
    private int idRicetta;
    private List<Ingrediente> ingredienti;
}
