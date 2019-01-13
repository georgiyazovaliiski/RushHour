package rushhour.rhproject.config;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collection;

public class ConverterToList {
    // function to convert Iterable into Collection
    public static <T> Collection<T>
    getCollectionFromIteralbe(Iterable<T> itr)
    {
        // Create an empty Collection to hold the result
        Collection<T> cltn = new ArrayList<T>();

        // Iterate through the iterable to
        // add each element into the collection
        for (T t : itr)
            cltn.add(t);

        // Return the converted collection
        return cltn;
    }

    public static Instant StringToInstant(String timestamp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        TemporalAccessor temporalAccessor = formatter.parse(timestamp);
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        Instant result = Instant.from(zonedDateTime);
        return result;
    }

    public static Duration StringToDuration(String duration){
        Long a = Long.parseLong(duration.split("-")[0])*3600+Long.parseLong(duration.split("-")[1])*60;
        return Duration.ofSeconds(a);
    }
}
