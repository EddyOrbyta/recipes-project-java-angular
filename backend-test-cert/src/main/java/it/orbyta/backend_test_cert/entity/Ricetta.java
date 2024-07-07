package it.orbyta.backend_test_cert.entity;

import it.orbyta.backend_test_cert.entity.enumerator.CategoriaRicettaEnum;
import it.orbyta.backend_test_cert.entity.enumerator.DifficoltaRicettaEnum;
import it.orbyta.backend_test_cert.entity.enumerator.TipoRicettaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "ricetta")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ricetta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String nome;
    @Column(name = "descrizione", length = 1024)
    private String descrizione;

    private String foto; //Blob
    private String video;  //Blob

    @Column(name = "preparazione", length = 2048)
    private String preparazione;

    @Column(name = "tempo_preparazione", nullable = false)
    private int tempoPreparazione; // in minuti

    @Column(name = "num_persone", nullable = false)
    private int numPersone;

    private DifficoltaRicettaEnum difficolta;
    private CategoriaRicettaEnum categoria;
    private TipoRicettaEnum tipo;

    private String userUid; // owner

    private int visualizzazioni;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


}
