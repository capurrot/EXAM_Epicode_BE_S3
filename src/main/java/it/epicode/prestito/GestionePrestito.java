package it.epicode.prestito;

import it.epicode.catalogo.ElementoBibliotecario;
import it.epicode.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gestioneprestito")
public class GestionePrestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestito;

    @ManyToOne
    @JoinColumn(name = "numeroditessera", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "codiceisbn", nullable = false)
    private ElementoBibliotecario elementoPrestato;

    @Column(nullable = false)
    private LocalDate dataInizioPrestito;

    @Column(nullable = false)
    private LocalDate dataRestituzionePrevista;

    @Column
    private LocalDate dataRestituzioneEffettiva;

    // Costruttore comodo per nuovo prestito (non ancora restituito)
    public GestionePrestito(Utente utente, ElementoBibliotecario elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}


