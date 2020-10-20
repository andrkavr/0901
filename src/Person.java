import java.time.*;
import java.time.format.DateTimeFormatter;

public class Person {
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Person(String firstName, String lastName, String birthDate, String birthTime){
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthDate = LocalDate.parse(birthDate, dateFormat);
        this.birthTime = LocalTime.parse(birthTime);
    }
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public LocalTime birthTime;

}
