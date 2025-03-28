package it.epicode.archivio;

import it.epicode.catalogo.Libro;
import it.epicode.catalogo.Periodicita;
import it.epicode.catalogo.Riviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCreaElementoBibliotecario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        Libro l1 = new Libro("Il Signore degli Anelli", 1954, 1000, "Tolkien", "Fantasy");
        Libro l2 = new Libro("Jack the Ripper", 2010, 500, "Wells", "Thriller");
        Libro l3 = new Libro("Harry Potter", 2001, 700, "Rowling", "Fantasy");
        Libro l4 = new Libro("Bosh", 2010, 500, "Wells", "Thriller");
        Riviste r1 = new Riviste("Focus", 2023, 50, Periodicita.MENSILE);
        Riviste r2 = new Riviste("Vanity Fair", 2023, 40, Periodicita.SEMESTRALE);
        Riviste r3 = new Riviste("National Geographic", 2023, 60, Periodicita.MENSILE);
        Riviste r4 = new Riviste("Vanity Fair", 2023, 40, Periodicita.SETTIMANALE);

        ArchivioDao dao = new ArchivioDao(em);
        em.getTransaction().begin();
        dao.insert(l1);
        dao.insert(l2);
        dao.insert(l3);
        dao.insert(l4);
        dao.insert(r1);
        dao.insert(r2);
        dao.insert(r3);
        dao.insert(r4);
        em.getTransaction().commit();
    }
}
