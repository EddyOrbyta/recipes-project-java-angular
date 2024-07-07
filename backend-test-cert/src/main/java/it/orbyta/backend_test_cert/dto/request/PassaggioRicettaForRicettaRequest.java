package it.orbyta.backend_test_cert.dto.request;

import lombok.Data;

@Data
public class PassaggioRicettaForRicettaRequest {

    private int idRicetta;
    private int numPassaggio;
    private String tipoPassaggio;
    private String descrizione;
}
