package it.epicode.catalogo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elementi-bibliotecari")
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

    public ElementoBibliotecario(String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}
