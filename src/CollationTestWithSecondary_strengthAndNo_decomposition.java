import java.util.ArrayList;
import java.util.List;

public class CollationTestWithSecondary_strengthAndNo_decomposition
{
	public static void main(String[] args)
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
	    
	    System.out.println("Here is the standard list of unicode strings ->");
	    System.out.println(unicodeStringList);
	}
}