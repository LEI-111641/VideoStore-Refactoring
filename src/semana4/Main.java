package semana4;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import demo.Database;
import vNew.ChildrensPrice;

/***********************************************************
 * Filename: Main.java
 * @author fba 6 de Mai de 2013
 ***********************************************************/
public abstract class Main {

    /***********************************************************
     * @param args
     ***********************************************************/
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        int response = -1;

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criar objetos e gravar");
        System.out.println("2 - Fazer load da DB\n");

        response = teclado.nextInt();

        switch (response) {
            case 1:
                createAndStoreData();
                break;

            case 2:
                loadFromDatabase();
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        teclado.close();
    }

    /***********************************************************
     * Criação de objetos, gravação na BD e geração do HTML
     ***********************************************************/
    private static void createAndStoreData() throws IOException {
        Customer who;
        who = new Customer("Barack Obama");

        // === Instanciar diferentes tipos de Price ===
        Price p1 = new RegularPrice();       // Filme normal
        Movie m1 = new Movie("Life of Amalia", p1);

        Price p2 = new ChildrenPrice();     // Filme infantil
        Movie m2 = new Movie("Peter Pan", p2);

        Price p3 = new NewReleasePrice();    // Novo lançamento
        Movie m3 = new Movie("Donna del Lago", p3);

        Price p4 = new BestPrice();          // 🆕 Novo tipo
        Movie m4 = new Movie("La Belle Epoque", p4);

        Price p5 = new BluRayPrice();        // 🆕 Blu-ray
        Movie m5 = new Movie("Avatar 2 (Blu-ray)", p5);

        // === Associar Rentals ao cliente ===
        who.addRental(new Rental(m1, 1));
        who.addRental(new Rental(m2, 2));
        who.addRental(new Rental(m3, 3));
        who.addRental(new Rental(m4, 2));
        who.addRental(new Rental(m5, 5));

        // === Grava na “base de dados” ===
        Database.store(who);
        Database.close();

        // === Output no terminal ===
        System.out.println(who.statement());

        // === Geração de ficheiro HTML ===
        PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
        html.println(who.htmlStatement());
        html.close();

        System.out.println("\nRelatório HTML gravado em 'webPages/statement.html'");
    }

    /***********************************************************
     * Carrega dados da “base de dados”
     ***********************************************************/
    private static void loadFromDatabase() throws IOException {
        Customer who = Database.get(Customer.class, "_name", "Barack Obama");

        System.out.println(who.statement());

        PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
        html.println(who.htmlStatement());
        html.close();

        Database.close();

        System.out.println("\nDados carregados e relatório gerado.");
    }
}