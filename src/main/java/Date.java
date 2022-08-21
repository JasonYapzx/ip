import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    protected LocalDate date;

    public Date(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}