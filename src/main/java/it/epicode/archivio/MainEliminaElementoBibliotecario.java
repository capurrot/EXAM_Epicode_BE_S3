package it.epicode.archivio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class MainEliminaElementoBibliotecario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        //Elimino elemento bibliotecario in base all'ISBN
        System.out.println("Inserisci ISBN dell'elemento da eliminare: ");
        long codiceIsbn = scanner.nextLong();
        System.out.println(codiceIsbn);
        ArchivioDao dao = new ArchivioDao(em);
        em.getTransaction().begin();
        dao.delete(codiceIsbn);
        em.getTransaction().commit();
    }
}
