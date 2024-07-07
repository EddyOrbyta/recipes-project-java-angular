package it.orbyta.backend_test_cert.dto.response;

import it.orbyta.backend_test_cert.entity.PassaggioRicetta;
import it.orbyta.backend_test_cert.entity.Ricetta;
import lombok.Data;

import java.util.List;

@Data
public class PassaggioRicettaListResponse {

    private List<PassaggioRicetta> passaggi;
}
