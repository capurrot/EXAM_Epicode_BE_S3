package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class MainRicercaPerTitolo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");

        try (emf; EntityManager em = emf.createEntityManager(); Scanner scanner = new Scanner(System.in)) {
            System.out.print("Inserisci il titolo dell'elemento da cercare: ");
            String titolo = scanner.nextLine();

            ArchivioDao dao = new ArchivioDao(em);
            List<ElementoBibliotecario> risultati = dao.findByTitolo(titolo);

            if (!risultati.isEmpty()) {
                System.out.println("Elementi trovati:");
                for (ElementoBibliotecario eb : risultati) {
                    System.out.println(eb);
                }
            } else {
                System.out.println("Nessun elemento trovato con titolo uguale o parziale: " + titolo);
            }
        } catch (Exception e) {
            System.err.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}