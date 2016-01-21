import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class HandleNonGregDefaultCalendarLocales
{
	private static List<Locale> bannedLocalesWhichCantUseDefaultCalendars;
	
	public static void main(String[] args)
	{
		populateBannedLocalesWhichCantUseDefaultCalendars();
		Locale defaultLocale = Locale.getDefault();
		Calendar defaultLocaleSpecificCalendar;
		if(!bannedLocalesWhichCantUseDefaultCalendars.contains(defaultLocale))
			{
				defaultLocaleSpecificCalendar=Calendar.getInstance(defaultLocale);
			}
		else
			{
				defaultLocaleSpecificCalendar=new GregorianCalendar(defaultLocale);
			}
	}

	private static void populateBannedLocalesWhichCantUseDefaultCalendars()
	{
		bannedLocalesWhichCantUseDefaultCalendars=new ArrayList<Locale>();
		bannedLocalesWhichCantUseDefaultCalendars.add(new Locale("ja","JP","JP"));
		bannedLocalesWhichCantUseDefaultCalendars.add(new Locale("th","TH",""));
		bannedLocalesWhichCantUseDefaultCalendars.add(new Locale("th","TH","TH"));
		
	}

}
