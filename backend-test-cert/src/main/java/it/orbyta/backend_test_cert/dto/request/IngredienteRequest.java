package it.orbyta.backend_test_cert.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class IngredienteRequest {

    private List<IngredienteDto> ingredienti;
}
