package it.orbyta.backend_test_cert.dto.request;

import it.orbyta.backend_test_cert.entity.enumerator.CategoriaRicettaEnum;
import it.orbyta.backend_test_cert.entity.enumerator.DifficoltaRicettaEnum;
import it.orbyta.backend_test_cert.entity.enumerator.TipoRicettaEnum;
import lombok.Data;

@Data
public class RicettaRequest {

    private String nome;
    private String descrizione;

    private String foto;
    private String video;

    private String preparazione;
    private int tempoPreparazione; // in minuti
    private int numPersone;

    private DifficoltaRicettaEnum difficolta;
    private CategoriaRicettaEnum categoria;
    private TipoRicettaEnum tipo;
}
