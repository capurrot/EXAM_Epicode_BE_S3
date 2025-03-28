package it.epicode.catalogo;

import it.epicode.prestito.GestionePrestito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elementibibliotecari")
public abstract class ElementoBibliotecario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codiceIsbn;

    @Column(length = 250, nullable = false)
    private String titolo;

    @Column(nullable = false)
    private int annoPubblicazione;

    @Column(nullable = false)
    private int numeroPagine;

    @OneToMany(mappedBy = "elementoPrestato", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<GestionePrestito> prestiti;

    public ElementoBibliotecario(String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}
