package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import it.epicode.prestito.PrestitoDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;


public class MainEliminaElementoBibliotecario {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in); EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode"); EntityManager em = emf.createEntityManager()) {

            System.out.print("Inserisci ISBN dell'elemento da eliminare: ");
            long codiceIsbn = scanner.nextLong();

            ArchivioDao dao = new ArchivioDao(em);
            PrestitoDao pdao = new PrestitoDao(em);
            ElementoBibliotecario eb = dao.findByIsdn(codiceIsbn);

            if (eb != null) {
                // Recupero codice ISBN dell'elemento
                long codiceIsbnElemento = eb.getCodiceIsbn();
                // Verifica se l'elemento è in prestito
                boolean inPrestito = pdao.isElementoInPrestito(codiceIsbnElemento);
                if (inPrestito) {
                    System.out.println("L'elemento è attualmente in prestito e non può essere eliminato.");
                    return;
                }
                em.getTransaction().begin();
                dao.delete(codiceIsbn);
                em.getTransaction().commit();
                System.out.println("Elemento eliminato correttamente: " + eb);
            } else {
                System.out.println("Nessun elemento trovato con ISBN: " + codiceIsbn);
            }

        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione: " + e.getMessage());
        }
    }
}

