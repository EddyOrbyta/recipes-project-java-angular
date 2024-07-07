package it.orbyta.backend_test_cert.dto.request;

import lombok.Data;

@Data
public class DettaglioIngredienteRicettaRequest {

    private int idRicetta;
    private int idIngrediente;
    private double quantita;
    private String unitaDiMisura;
}
