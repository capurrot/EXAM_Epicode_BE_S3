package it.epicode.prestito;

import it.epicode.catalogo.ElementoBibliotecario;
import it.epicode.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GestionePrestito {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_id", nullable = false)
    private ElementoBibliotecario elementoPrestato;

    private LocalDate dataInizioPrestito;

    private LocalDate dataRestituzionePrevista;

    private LocalDate dataRestituzioneEffettiva;

    private boolean restituito;

    private boolean scaduto;

    @PrePersist
    public void calcolaDataRestituzionePrevista() {
        if (dataInizioPrestito != null && dataRestituzionePrevista == null) {
            this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        }
    }
}




