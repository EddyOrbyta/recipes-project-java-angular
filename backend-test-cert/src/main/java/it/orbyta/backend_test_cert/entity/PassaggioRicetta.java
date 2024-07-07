package it.orbyta.backend_test_cert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passaggio_ricetta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassaggioRicetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "num_passaggio", nullable = false)
    private int numPassaggio;


    @ManyToOne
    @JoinColumn(name = "id_ricetta")
    private Ricetta ricetta;

    @Column(name = "tipo_passaggio", nullable = false)
    private String tipoPassaggio;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

}
