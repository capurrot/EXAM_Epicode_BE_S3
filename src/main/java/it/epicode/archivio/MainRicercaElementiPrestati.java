package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import it.epicode.prestito.PrestitoDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class MainRicercaElementiPrestati {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");

        try (emf; EntityManager em = emf.createEntityManager(); Scanner scanner = new Scanner(System.in)) {
            System.out.print("Inserisci il numero della tessera dell'utente: ");
            long numeroTessera = scanner.nextLong();
            scanner.nextLine();
            PrestitoDao pdao = new PrestitoDao(em);

            List<ElementoBibliotecario> risultati = pdao.findByNumeroTessera(numeroTessera);
            if (!risultati.isEmpty()) {
                System.out.println("Elementi trovati:");
                for (ElementoBibliotecario eb : risultati) {
                    System.out.println(eb);
                }
            } else {
                System.out.println("Nessun elemento trovato per la tessera: " + numeroTessera);
            }

        } catch (Exception e) {
            System.err.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}