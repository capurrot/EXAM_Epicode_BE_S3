package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArchivioDao {
    private EntityManager em;

    public void insert (ElementoBibliotecario eb) {
        em.persist(eb);
        //visualizzo messaggio di inserimento
        System.out.println("Elemento inserito correttamente: " + eb.toString());
    }

    public void update (ElementoBibliotecario e) {
        em.merge(e);
    }

    public void delete(Long codiceIsbn) {
        ElementoBibliotecario eb = findByIsdn(codiceIsbn);
        if (eb != null) {
            em.remove(eb);
            System.out.println("Elemento con ISBN " + codiceIsbn + " eliminato correttamente");
        } else {
            System.out.println("Elemento non trovato");
        }
    }

    //ricerca per ISBN
    public ElementoBibliotecario findByIsdn (long codiceIsbn) {
        return em.find(ElementoBibliotecario.class, codiceIsbn);
    }

    //ricerca per anno di pubblicazione
    public ElementoBibliotecario getByAnnoPubblicazione (int anno) {
        return em.find(ElementoBibliotecario.class, anno);
    }

}