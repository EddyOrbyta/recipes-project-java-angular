package it.orbyta.backend_test_cert.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RatingRequest {

    private int idRicetta;
    @Min(0)
    @Max(5)
    private int score;
}
