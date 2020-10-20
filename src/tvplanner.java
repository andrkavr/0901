import java.time.LocalDate;
import java.time.LocalTime;

public class tvplanner {
    String progName;
    LocalTime startTime;
    LocalTime stopTime;
    LocalDate viewDate;

    public tvplanner(String rad) {
        String[] delad = rad.split(";");
        progName = delad[0];
        startTime = LocalTime.parse(delad[1]);
        stopTime = LocalTime.parse(delad[2]);
        viewDate = LocalDate.parse(delad[3]);
    }

    public tvplanner(String program, LocalTime timestart, LocalTime timeend, LocalDate viewDate) {
        this.progName = program;
        this.startTime = timestart;
        this.stopTime = timeend;
        this.viewDate = viewDate;

    }
}

