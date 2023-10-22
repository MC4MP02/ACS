package baseNoStates;

import java.time.*;
import java.util.ArrayList;

// schedule class that has times and days, we need the class for the most time aspects 
public class Schedule {
    private LocalDate dateInici;
    private LocalDate dateFin;
    private LocalTime timeInici;
    private LocalTime timeFin;
    private ArrayList<DayOfWeek> days;

    // class constructor with all class atributes
    public Schedule(LocalDate dateInici, LocalDate dateFin, ArrayList<DayOfWeek> days, LocalTime timeInici,
            LocalTime timeFin) {
        this.dateInici = dateInici;
        this.dateFin = dateFin;
        this.days = days;
        this.timeInici = timeInici;
        this.timeFin = timeFin;
    }

    // all getters

    public LocalDate getDateInici() {
        return dateInici;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public LocalTime getTimeInici() {
        return timeInici;
    }

    public LocalTime getTimeFin() {
        return timeFin;
    }

    public ArrayList<DayOfWeek> getDays() {
        return days;
    }
}
