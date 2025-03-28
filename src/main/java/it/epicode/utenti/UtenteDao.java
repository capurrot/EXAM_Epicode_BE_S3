package it.epicode.utenti;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UtenteDao {
    private EntityManager em;

    public void insert (Utente u) {
        em.persist(u);
        //visualizzo messaggio di inserimento
        System.out.println("Utente inserito correttamente: " + u.toString());
    }
}
