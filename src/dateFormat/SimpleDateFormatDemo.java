package dateFormat;

import java.util.*;
import java.text.*;

public class SimpleDateFormatDemo {

   static public void displayDate(Locale currentLocale) {

      Date today;
      String result;
      SimpleDateFormat formatter;

      formatter = new SimpleDateFormat("EEE d MMM yy", currentLocale);
      today = new Date();
      result = formatter.format(today);

      System.out.println("Locale: " + currentLocale.toString());
      System.out.println("("+formatter.toPattern()+")--> " + result);
   }


   static public void displayPattern(String pattern, Locale currentLocale) {

      Date today;
      SimpleDateFormat formatter;
      String output;

      formatter = new SimpleDateFormat(pattern, currentLocale);
      today = new Date();
      output = formatter.format(today);

      System.out.println("Locale: "+currentLocale);
      System.out.println("("+pattern + ")-->  " + output);
   }

   static public void main(String[] args) {

      Locale[] locales = {
          new Locale("fr","FR"),
          new Locale("de","DE"),
          new Locale("en","US"),
          new Locale("en","GB")
          //new Locale("zh","CN")
      };

      System.out.println("---------------------------<EEE d MMM yy>-----------------------------------------");
      for (int i = 0; i < locales.length; i++) {
         displayDate(locales[i]);
         System.out.println();
      }
      System.out.println("-----------------------------------------------------------------------------------");


      String[] patterns = {
         "dd.MM.yy",
         "yyyy.MM.dd G 'at' hh:mm:ss", //G is era designator like A.D
         "EEE, MMM d, ''yy", //E is day of week like Monday, Lundi
         "h:mm a", //a is am/pm marker
         "H:mm",
         "H:mm:ss:SSS",
         "K:mm a",
         "yyyy.MMMMM.dd GGG hh:mm aaa"
      };

      System.out.println();
      System.out.println("--------------------------------Custom pattern---------------------------------------------------");
      for (int k = 0; k < patterns.length; k++) {
    	  for(int i = 0; i < locales.length; i++){
         displayPattern(patterns[k], locales[i]);
         System.out.println();
      }}
      System.out.println("--------------------------------------------------------------------------------------------------");

      System.out.println();
   }
}
