package masterspringmvc.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Aspire on 25.03.2017.
 */
public class USLocalDateFormatter implements Formatter<LocalDate>{
    public static final String US_PATTERN = "MM/dd/yyyy";
    public static final String RU_PATTERN = "dd/MM/yyyy";
    public static final String NORMAL_PATTERN = "dd/MM/yyyy";

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    public static String getPattern(Locale locale) {
        if(Locale.US.getCountry().equals(locale.getCountry())){
            return US_PATTERN;
        }else if (locale.equals("ru")){
            return RU_PATTERN;
        }else{
            return NORMAL_PATTERN;
        }
    }
}
