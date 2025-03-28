package it.epicode.prestito;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrestitoDao {
    private EntityManager em;

    public void insert (GestionePrestito p) {
        em.persist(p);
        //visualizzo messaggio di inserimento
        System.out.println("Prestito inserito correttamente: " + p.toString());
    }

    public boolean isElementoInPrestito(long codiceIsbn) {
        Long count = em.createQuery(
                        "SELECT COUNT(p) FROM GestionePrestito p WHERE p.elementoPrestato.codiceIsbn = :isbn AND p.dataRestituzioneEffettiva IS NULL",
                        Long.class)
                .setParameter("isbn", codiceIsbn)
                .getSingleResult();

        return count > 0;
    }

}