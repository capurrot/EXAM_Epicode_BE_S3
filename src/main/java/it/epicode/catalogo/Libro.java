package it.epicode.catalogo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libri")
public class Libro extends ElementoBibliotecario {

    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    private String genere;

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "ISBN=" + getCodiceIsbn() +
                ", Titolo='" + getTitolo() + '\'' +
                ", Anno di pubblicazione=" + getAnnoPubblicazione() +
                ", Numero pagine=" + getNumeroPagine() +
                ", Autore='" + autore + '\'' +
                ", Genere='" + genere + '\'' +
                '}';
    }
}

