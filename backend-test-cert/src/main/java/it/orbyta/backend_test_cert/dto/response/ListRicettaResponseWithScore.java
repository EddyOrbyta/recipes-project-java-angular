package it.orbyta.backend_test_cert.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRicettaResponseWithScore {
    private List<RicettaWithScoreResponse> ricettaList;
    private int totalPages;
    private int currentPage;
    private int totalElements;
}
