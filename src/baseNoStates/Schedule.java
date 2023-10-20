package baseNoStates;

import java.time.*;
import java.util.ArrayList;

public class Schedule {
    private LocalDate dateInici;
    private LocalDate dateFin;
    private LocalTime timeInici;
    private LocalTime timeFin;
    private ArrayList<DayOfWeek> days;

    public Schedule(LocalDate dateInici, LocalDate dateFin, ArrayList<DayOfWeek> days, LocalTime timeInici, LocalTime timeFin) {
        this.dateInici = dateInici;
        this.dateFin = dateFin;
        this.days = days;
        this.timeInici = timeInici;
        this.timeFin = timeFin;
    }

    public LocalDate getDateInici() { return dateInici; }

    public LocalDate getDateFin() { return dateFin; }

    public LocalTime getTimeInici() { return timeInici; }

    public LocalTime getTimeFin() { return timeFin; }

    public ArrayList<DayOfWeek> getDays() { return days; }
}
