package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArchivioDao {
    private EntityManager em;

    public void insert (ElementoBibliotecario e) {
        em.persist(e);
    }

    public void update (ElementoBibliotecario e) {
        em.merge(e);
    }

    public void delete (ElementoBibliotecario e) {
        em.remove(e);
    }

    //ricerca per ISBN
    public ElementoBibliotecario getByISBN (int isbn) {
        return em.find(ElementoBibliotecario.class, isbn);
    }
    //ricerca per anno di pubblicazione
    public ElementoBibliotecario getByAnnoPubblicazione (int anno) {
        return em.find(ElementoBibliotecario.class, anno);
    }

}