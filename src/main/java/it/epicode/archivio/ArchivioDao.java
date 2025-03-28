package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

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
            em.remove(eb);
    }

    //ricerca per ISBN
    public ElementoBibliotecario findByIsdn (long codiceIsbn) {
        return em.find(ElementoBibliotecario.class, codiceIsbn);
    }

    //ricerca per anno di pubblicazione
    public List<ElementoBibliotecario> findByAnnoPubblicazione(int annoPubblicazione) {
        return em.createQuery("SELECT eb FROM ElementoBibliotecario eb WHERE eb.annoPubblicazione = :anno", ElementoBibliotecario.class)
                .setParameter("anno", annoPubblicazione)
                .getResultList();
    }

    //ricerca per autore
    public List<ElementoBibliotecario> findByAutore(String autore) {
        return em.createQuery("SELECT eb FROM ElementoBibliotecario eb WHERE eb.autore = :autore", ElementoBibliotecario.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    //ricerca per titolo
    public ElementoBibliotecario findByTitolo (String titolo) {
        return em.find(ElementoBibliotecario.class, titolo);
    }

}