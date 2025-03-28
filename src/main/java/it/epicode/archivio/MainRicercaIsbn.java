package it.epicode.archivio;

import it.epicode.catalogo.ElementoBibliotecario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class MainRicercaIsbn {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci ISBN dell'elemento da cercare: ");
        long codiceIsbn = scanner.nextLong();
        ArchivioDao dao = new ArchivioDao(em);
        ElementoBibliotecario eb = dao.findByIsdn(codiceIsbn);
        if (eb != null) {
            System.out.println("Elemento trovato: " + eb.toString());
        } else {
            System.out.println("Elemento non trovato");
        }
    }
}
