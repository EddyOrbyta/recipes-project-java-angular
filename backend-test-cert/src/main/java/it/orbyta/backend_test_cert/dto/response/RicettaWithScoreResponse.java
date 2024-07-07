package it.orbyta.backend_test_cert.dto.response;

import it.orbyta.backend_test_cert.entity.Ricetta;
import lombok.Data;
@Data
public class RicettaWithScoreResponse {

    private Ricetta ricetta;
    private double score;
}
