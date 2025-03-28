package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class MainRicercaIsbn {
    public static void main(String[] args) {

        // try catch modificato da intellij per diminuire righe di codice
        try (Scanner scanner = new Scanner(System.in); EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode"); EntityManager em = emf.createEntityManager()) {

            System.out.print("Inserisci ISBN dell'elemento da cercare: ");
            long codiceIsbn = scanner.nextLong();

            ArchivioDao dao = new ArchivioDao(em);
            ElementoBibliotecario eb = dao.findByIsdn(codiceIsbn); // corretto qui

            if (eb != null) {
                System.out.println("Elemento trovato: " + eb);
            } else {
                System.out.println("Elemento non trovato.");
            }

        } catch (Exception e) {
            System.err.println("Errore durante la ricerca: " + e.getMessage());
        }
    }
}
