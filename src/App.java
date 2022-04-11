import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class App {

    // Konwersja java.util.Date -> java.time.LocalDate
    static LocalDate toLocalDateV1(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    static LocalDate toLocalDateV2(Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    // Konwersja java.util.Date -> java.time.LocalDateTime

    static LocalDateTime toLocalDateTimeV1(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    static LocalDateTime toLocalDateTimeV2(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    // Konwersja java.time.LocalDate -> java.util.Date

    static Date toDate(LocalDate date) {
        return Date
                .from(date.atStartOfDay(ZoneId.systemDefault())
                        .toInstant());
    }

    // Konwersja java.time.LocalDateTime -> java.util.Date

    static Date toDate(LocalDateTime dateTime) {
        return Date
                .from(dateTime.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------ (1) ------------------------------------");
        var date = new Date();
        System.out.println(date);

        System.out.println("------------------------------------ (2) ------------------------------------");
        System.out.println(toLocalDateV1(date));
        System.out.println(toLocalDateV2(date));

        System.out.println("------------------------------------ (3) ------------------------------------");
        System.out.println(toLocalDateTimeV1(date));
        System.out.println(toLocalDateTimeV2(date));

        System.out.println("------------------------------------ (4) ------------------------------------");
        var date2 = LocalDate.now();
        System.out.println(toDate(date2));

        System.out.println("------------------------------------ (5) ------------------------------------");
        var dateTime = LocalDateTime.now();
        System.out.println(toDate(dateTime));
    }
}
