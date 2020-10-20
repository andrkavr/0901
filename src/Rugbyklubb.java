public class Rugbyklubb {
    String forName;
    String efterName;
    String phoneNr;

    public Rugbyklubb(String rad){
        String[] delad = rad.split(";");
        forName = delad[0];
        efterName = delad[1];
        phoneNr = delad[2];
    }
    public Rugbyklubb(String foreName, String afterName, String telNR) {

        this.forName = foreName;
        this.efterName = afterName;
        this.phoneNr = telNR;
    }
}
