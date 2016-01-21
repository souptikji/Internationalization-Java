import java.text.Collator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TestIfAllLocalesHaveGregorianCalendar
	{
		private static Locale[] allAvailableLocales;
		
		public static void main(String[] args)
		{
			populateAllAvailableLocales();
			printListOfLocales();
			System.out.println();
			printLocaleAndCalendarType();
			System.out.println();
			List<Locale> listOfLocalesWhichDontHaveGregorianCalendarType= getListOfLocalesWhichDontHaveGregorianCalendarType();
			System.out.println("List of Locales which don't have a GregorianCalendar as default calendar -> ");
			prettyPrintLocaleList(listOfLocalesWhichDontHaveGregorianCalendarType);

		}

		private static void prettyPrintLocaleList(List<Locale> listOfLocales)
		{
			for(Locale locale:listOfLocales)
				{
					System.out.println(locale.getDisplayName()+"-> ("+locale.getLanguage()+"/"+locale.getCountry()+")  : "+locale.getVariant());
				}
		}

		private static List<Locale> getListOfLocalesWhichDontHaveGregorianCalendarType()
		{
			List<Locale> list = new ArrayList<Locale>();
			Calendar localeSpecificCalendar;
			for(Locale locale: allAvailableLocales)
				{
					localeSpecificCalendar = Calendar.getInstance(locale);
					if(localeSpecificCalendar.getClass().getName()!="java.util.GregorianCalendar")
						{
							list.add(locale);
						}
				}
			return list;
		}

		private static void populateAllAvailableLocales()
		{
			allAvailableLocales = (Locale[]) Collator.getAvailableLocales().clone();
		}
		
		private static void printListOfLocales()
		{
			System.out.println("*************************List of available locales****************************");
			for(Locale locale:allAvailableLocales)
				{
					System.out.println(locale.getDisplayName());
				}
			System.out.println("******************************************************************************");
		}
		
		private static void printLocaleAndCalendarType()
			{
				Calendar localeSpecificCalendar;
				System.out.println("*************************List of available locales with locale specific calendars****************************");
				for(Locale locale:allAvailableLocales)
					{
						localeSpecificCalendar = Calendar.getInstance(locale);
						System.out.println(locale.getDisplayName()+" -> "+localeSpecificCalendar.getClass());
					}
				System.out.println("*************************************************************************************************************");
			}

	}
