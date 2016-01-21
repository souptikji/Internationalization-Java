import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CollationTestWithSecondary_strengthAndNo_decomposition
{
	public static void main(String[] args)
	{
		List<String> unicodeStringList = createTestData();
	    
	    System.out.println("Here is the standard list of unicode strings ->");
	    System.out.println(unicodeStringList);
	    
	    
	    System.out.println("Here is the list of unicode strings after sorting by default ->");
	    sortAsPerLocale(unicodeStringList,null,null);
	    System.out.println(unicodeStringList);
	    
	    System.out.println("Here is the list of unicode strings after sorting in Swedish locale ->");
	    //country codes in http://www.oracle.com/technetwork/java/javase/javase7locales-334809.html
	    sortAsPerLocale(unicodeStringList,"sv", "SE");
	    System.out.println(unicodeStringList);
	}

	private static void sortAsPerLocale(List<String> unicodeStringList, String language, String country)
		{
			Locale locale;
			if(language==null && country==null)
				{
					locale= Locale.getDefault();
				}
			
			else
				{
					locale= new Locale(language, country);
				}
			
			Collator localeBasedCollator= Collator.getInstance(locale);
			Collections.sort(unicodeStringList,localeBasedCollator);
		}

	private static List<String> createTestData()
		{
			List<String> unicodeStringList = new ArrayList<String>();
			unicodeStringList.add("America");
			unicodeStringList.add("able");
			unicodeStringList.add("Zulu");
			unicodeStringList.add("zebra");
			unicodeStringList.add("\u00C5ngstr\u00F6m");
			unicodeStringList.add("A\u030angstro\u0308m");
			unicodeStringList.add("Angstrom");
			unicodeStringList.add("Able");
			unicodeStringList.add("office");
			unicodeStringList.add("o\uFB03ce");
			unicodeStringList.add("Java\u2122");
			unicodeStringList.add("JavaTM");
			unicodeStringList.add("\u00C5bcde");
			
			return unicodeStringList;
		}
}