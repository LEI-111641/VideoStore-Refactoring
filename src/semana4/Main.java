package semana4;

import v9.ChildrensPrice;
import v9.Customer;
import v9.Movie;
import v9.NewReleasePrice;
import v9.Price;
import v9.RegularPrice;
import v9.Rental;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/***********************************************************
 * Filename: Main.java
 * @author fba 6 de Mai de 2013
 ***********************************************************/
public abstract class Main
{

	/***********************************************************
	 * @param args
	 ***********************************************************/
	public static void main(String[] args) throws IOException {
        v9.Price regularPrice = new RegularPrice();
        v9.Price childrensPrice = new ChildrensPrice();
        Price newReleasePrice = new NewReleasePrice();

        v9.Customer who = new Customer("Barack Obama");
        v9.Movie m1 = new v9.Movie("Life of Amalia", regularPrice);
        v9.Movie m2 = new v9.Movie("Peter Pan", childrensPrice);
        v9.Movie m3 = new Movie("Donna del Lago", newReleasePrice);

        who.addRental(new v9.Rental(m1, 1));
        who.addRental(new v9.Rental(m2, 2));
        who.addRental(new Rental(m3, 3));
        System.out.println( who.statement());

        PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
        html.println(who.htmlStatement());
        html.close();
	}

}
