package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class MainRicercaPerAnnoPubblicazione {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");

        try (emf; EntityManager em = emf.createEntityManager(); Scanner scanner = new Scanner(System.in)) {
            System.out.print("Inserisci anno di pubblicazione dell'elemento da cercare: ");
            int annoPubblicazione = scanner.nextInt();

            ArchivioDao dao = new ArchivioDao(em);
            List<ElementoBibliotecario> risultati = dao.findByAnnoPubblicazione(annoPubblicazione);

            if (!risultati.isEmpty()) {
                System.out.println("Elementi trovati:");
                for (ElementoBibliotecario eb : risultati) {
                    System.out.println(eb);
                }
            } else {
                System.out.println("Nessun elemento trovato per l'anno " + annoPubblicazione);
            }
        } catch (Exception e) {
            System.err.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}
