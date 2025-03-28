package it.epicode.catalogo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "riviste")
public class Riviste extends ElementoBibliotecario {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista {" +
                "ISBN=" + getCodiceIsbn() +
                ", Titolo='" + getTitolo() + '\'' +
                ", Anno di pubblicazione=" + getAnnoPubblicazione() +
                ", Numero pagine=" + getNumeroPagine() +
                ", Periodicità=" + periodicita +
                '}';
    }
}
