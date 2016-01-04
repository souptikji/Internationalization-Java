package dateFormat;

import java.util.*;
import java.text.*;

public class DateFormatDemo {

   static public void displayDate(Locale currentLocale) {

      Date today;
      String dateOut;
      DateFormat dateFormatter;

      dateFormatter = 
         DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
      today = new Date();
      dateOut = dateFormatter.format(today);

      System.out.println(dateOut + "   " + currentLocale.toString());
   }

   static public void showBothStyles(Locale currentLocale) {

      Date today;
      String result;
      DateFormat formatter;

      int[] styles = {
         DateFormat.DEFAULT,
         DateFormat.SHORT, 
         DateFormat.MEDIUM,
         DateFormat.LONG,
         DateFormat.FULL
      };

      System.out.println();
      System.out.println("Locale: " + currentLocale.toString());
      //System.out.println();

      today = new Date();

      for (int k = 0; k < styles.length; k++) {
         formatter = DateFormat.getDateTimeInstance(
                     styles[k], styles[k], currentLocale);
         result = formatter.format(today);
         System.out.println(result);
      }
   }

   static public void showDateStyles(Locale currentLocale) {

      Date today = new Date();
      String result;
      DateFormat formatter;

      int[] styles = {
         DateFormat.DEFAULT,
         DateFormat.SHORT, 
         DateFormat.MEDIUM,
         DateFormat.LONG,
         DateFormat.FULL
      };

      System.out.println();
      System.out.println("Locale: " + currentLocale.toString());
      //System.out.println();

      for (int k = 0; k < styles.length; k++) {
         formatter = 
            DateFormat.getDateInstance(styles[k], currentLocale);
         result = formatter.format(today);
         System.out.println(result);
      }
   }

   static public void showTimeStyles(Locale currentLocale) {

      Date today = new Date();
      String result;
      DateFormat formatter;

      int[] styles = {
         DateFormat.DEFAULT,
         DateFormat.SHORT, 
         DateFormat.MEDIUM,
         DateFormat.LONG,
         DateFormat.FULL
      };

      System.out.println();
      System.out.println("Locale: " + currentLocale.toString());
      //System.out.println();

      for (int k = 0; k < styles.length; k++) {
         formatter = 
            DateFormat.getTimeInstance(styles[k], currentLocale);
         result = formatter.format(today);
         System.out.println(result);
      }
   }

   static public void main(String[] args) {

      Locale[] locales = {
          new Locale("fr","FR"),
          new Locale("de","DE"),
          new Locale("en","US")
      };
     
      for (int i = 0; i < locales.length; i++) {
         displayDate(locales[i]);
      }

      System.out.println("-----------------------------------------------------------");
      showDateStyles(new Locale("en","US"));
      showDateStyles(new Locale("fr","FR"));
      showDateStyles(new Locale("de","DE"));
      System.out.println("-----------------------------------------------------------");

      showTimeStyles(new Locale("en","US"));
      showTimeStyles(new Locale("fr","FR"));
      showTimeStyles(new Locale("de","DE"));
      System.out.println("-----------------------------------------------------------");
 
      showBothStyles(new Locale("en","US"));
      showBothStyles(new Locale("fr","FR"));
      showBothStyles(new Locale("de","DE"));
      System.out.println("-----------------------------------------------------------");

   }
}
