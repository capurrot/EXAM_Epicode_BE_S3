package it.epicode.archivio;

import it.epicode.catalogo.Libro;
import it.epicode.catalogo.Periodicita;
import it.epicode.catalogo.Riviste;
import it.epicode.prestito.GestionePrestito;
import it.epicode.prestito.PrestitoDao;
import it.epicode.utenti.Utente;
import it.epicode.utenti.UtenteDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainAggiungiElementoBibliotecario {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("epicode");
            em = emf.createEntityManager();

            Libro l1 = new Libro("Il Signore degli Anelli", 1954, 1000, "Tolkien", "Fantasy");
            Libro l2 = new Libro("Jack the Ripper", 2010, 500, "Wells", "Thriller");
            Libro l3 = new Libro("Harry Potter", 2001, 700, "Rowling", "Fantasy");
            Libro l4 = new Libro("Bosh", 2010, 500, "Wells", "Thriller");

            Riviste r1 = new Riviste("Focus", 2023, 50, Periodicita.MENSILE);
            Riviste r2 = new Riviste("Vanity Fair", 2023, 40, Periodicita.SEMESTRALE);
            Riviste r3 = new Riviste("National Geographic", 2023, 60, Periodicita.MENSILE);
            Riviste r4 = new Riviste("Vanity Fair", 2023, 40, Periodicita.SETTIMANALE);

            Utente u1 = new Utente("Mario", "Rossi", LocalDate.of(1990, 1, 15));
            Utente u2 = new Utente("Giuseppe", "Verdi", LocalDate.of(1995, 5, 20));
            Utente u3 = new Utente("Luca", "Bianchi", LocalDate.of(1985, 8, 10));
            Utente u4 = new Utente("Anna", "Neri", LocalDate.of(1992, 3, 25));
            Utente u5 = new Utente("Maria", "Gialli", LocalDate.of(1988, 12, 5));
            Utente u6 = new Utente("Paolo", "Marroni", LocalDate.of(1998, 7, 30));
            Utente u7 = new Utente("Sara", "Rosa", LocalDate.of(1980, 9, 18));
            Utente u8 = new Utente("Davide", "Blu", LocalDate.of(1993, 4, 22));

            GestionePrestito p1 = new GestionePrestito(u3, l1, LocalDate.of(2023, 11, 1), LocalDate.of(2023, 12, 5));
            GestionePrestito p2 = new GestionePrestito(u4, l2, LocalDate.of(2023, 10, 15), null);
            GestionePrestito p3 = new GestionePrestito(u2, r1, LocalDate.of(2023, 9, 10), LocalDate.of(2023, 10, 15));
            GestionePrestito p4 = new GestionePrestito(u4, r2, LocalDate.of(2023, 8, 5), null);
            GestionePrestito p5 = new GestionePrestito(u1, l3, LocalDate.of(2023, 7, 20), LocalDate.of(2023, 8, 10));
            GestionePrestito p6 = new GestionePrestito(u5, r3, LocalDate.of(2023, 6, 15), null);
            GestionePrestito p7 = new GestionePrestito(u6, l4, LocalDate.of(2023, 5, 25), LocalDate.of(2023, 6, 20));
            GestionePrestito p8 = new GestionePrestito(u7, r4, LocalDate.of(2025, 3, 15), null);

            ArchivioDao dao = new ArchivioDao(em);
            UtenteDao udao = new UtenteDao(em);
            PrestitoDao pdao = new PrestitoDao(em);

            em.getTransaction().begin();
            dao.insert(l1);
            dao.insert(l2);
            dao.insert(l3);
            dao.insert(l4);
            dao.insert(r1);
            dao.insert(r2);
            dao.insert(r3);
            dao.insert(r4);
            udao.insert(u1);
            udao.insert(u2);
            udao.insert(u3);
            udao.insert(u4);
            udao.insert(u5);
            udao.insert(u6);
            udao.insert(u7);
            udao.insert(u8);
            pdao.insert(p1);
            pdao.insert(p2);
            pdao.insert(p3);
            pdao.insert(p4);
            pdao.insert(p5);
            pdao.insert(p6);
            pdao.insert(p7);
            pdao.insert(p8);
            em.getTransaction().commit();

            System.out.println("Elementi inseriti correttamente nel database.");

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
