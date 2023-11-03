package basenostates;

import java.time.*;
import java.util.ArrayList;

/**
 *Schedule class that has times and days.
 *We need the class for the most time aspects.
 */

public class Schedule {
    private LocalDate dateInici;
    private LocalDate dateFin;
    private LocalTime timeInici;
    private LocalTime timeFin;
    private ArrayList<DayOfWeek> days;


    public Schedule(LocalDate dateInici, LocalDate dateFin, ArrayList<DayOfWeek> days, LocalTime timeInici,
            LocalTime timeFin) {
        this.dateInici = dateInici;
        this.dateFin = dateFin;
        this.days = days;
        this.timeInici = timeInici;
        this.timeFin = timeFin;
    }


    //we use this function to know if we are between correct hours to confirm that
    //we are in the correct schedule, we use that for the user's schedules.
    //returns a boolean.
    public boolean isSchedule(LocalDateTime now) {
        boolean daysTrue = days.contains(now.getDayOfWeek());
        boolean dateTrue = now.toLocalDate().isAfter(dateInici) && now.toLocalDate().isBefore(dateFin);
        boolean timeTrue = now.toLocalTime().isAfter(timeInici) && now.toLocalTime().isBefore(timeFin);

        return daysTrue && dateTrue && timeTrue;
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
