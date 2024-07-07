package it.orbyta.backend_test_cert.dto.response;

import it.orbyta.backend_test_cert.entity.Ricetta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRicettaResponse {
    private List<Ricetta> ricettaList;
    private int totalPages;
    private int currentPage;
    private int totalElements;
}
