package dateFormat;
import java.text.*;
import java.util.*;
import java.io.*;

/**
 * A partial implementation of a hypothetical stock portfolio class.
 * We use it only to demonstrate number and date internationalization.
 **/
public class GetFormatsFromConfigurations {
    DataObject[] positions;
    Date lastQuoteTime = new Date();

    public GetFormatsFromConfigurations(DataObject[] positions, Date lastQuoteTime) {
	this.positions = positions;
	this.lastQuoteTime = lastQuoteTime;
    }
    
    public void print(PrintWriter out) {
        // Obtain NumberFormat and DateFormat objects to format our data.
        NumberFormat number = NumberFormat.getInstance();
        NumberFormat price = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        DateFormat shortdate = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat fulldate = DateFormat.getDateTimeInstance(DateFormat.LONG,
							     DateFormat.LONG);
	
        // Print some introductory data.
        out.println("Date at " +
		    fulldate.format(lastQuoteTime) + ":");
        out.println("Name\t\tInteger\t\tDate\t\tDecimal1\t" +
		    "Decimal2\tChange");
	
        // Display the table using the format() methods of the Format objects.
        for(int i = 0; i < positions.length; i++) {
            out.print(positions[i].name + "\t\t");
            out.print(number.format(positions[i].fullIntegers) + "\t\t");
            out.print(shortdate.format(positions[i].shortDates) + "\t");
            out.print(price.format(positions[i].decimal1) + "\t\t");
            out.print(price.format(positions[i].decimal2) + "\t\t");
            double change =
                (positions[i].decimal2-positions[i].decimal1)/positions[i].decimal1;
            out.println(percent.format(change));
	    out.flush();
        }
    }
    
    static class DataObject {
        String name;             
        int fullIntegers;         
        Date shortDates;         
        double decimal1;           
	    double decimal2;          
        DataObject(String name, int fullIntegers, Date shortDates, double decimal1, double decimal2) {
            this.name = name; 
            this.fullIntegers = fullIntegers; 
            this.shortDates = shortDates;
	        this.decimal1 = decimal1; 
	        this.decimal2 = decimal2;
        }
    }

    /**
     * This is a test program that demonstrates the class
     * use de_DE
     * use en US
     * use en GB
     * use fr FR
     * 
     **/
    public static void main(String[] args) {
	// This is the portfolio to display.  Note we use a deprecated
	// Date() constructor here for convenience. It represents the year
	// offset from 1900, and will cause a warning message when compiling.
	DataObject[] positions = new DataObject[] {
	    new DataObject("Value", 40000, new Date(),11.90,13.00),
	    new DataObject("Value", 120000, new Date(),2.56,13.90)
	};

	// Create the portfolio from these positions
	GetFormatsFromConfigurations representation = new GetFormatsFromConfigurations(positions, new Date());

        // Set the default locale using the language code and country code
	// specified on the command line.
        if (args.length == 2) Locale.setDefault(new Locale(args[0], args[1]));

	// Now print the portfolio
	representation.print(new PrintWriter(System.out));
    }
}
