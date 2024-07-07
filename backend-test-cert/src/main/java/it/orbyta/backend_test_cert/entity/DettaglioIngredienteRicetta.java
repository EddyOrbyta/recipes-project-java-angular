package it.orbyta.backend_test_cert.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "dettaglio_ingrediente_ricetta")
@Data
@Builder
public class DettaglioIngredienteRicetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "quantita", nullable = false)
    private double quantita;

    private String untiaDiMisura;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "id_ricetta")
    private Ricetta ricetta;
}
