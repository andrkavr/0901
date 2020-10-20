import java.time.LocalDate;
import java.time.LocalTime;

public class tvplanners {
    String progName;
    LocalTime startTime;
    LocalTime stopTime;
    LocalDate viewDate;

    public tvplanners(String rad) {
        //System.out.println(rad);
        String[] delad = rad.split(";");
        progName = delad[0];
        startTime = LocalTime.parse(delad[1]);
        stopTime = LocalTime.parse(delad[2]);
        viewDate = LocalDate.parse(delad[3]);
    }

    public tvplanners(String program, LocalTime timestart, LocalTime timeend, LocalDate viewDate) {
            this.progName = program;
            this.startTime = timestart;
            this.stopTime = timeend;
            this.viewDate = viewDate;

        }
    }

