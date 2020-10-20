public class UserTV {
    public enum Clearance {
        NONE,
        USER,
        ADMIN,
        SUPERUSER
    }

    public String userName;
    public String password;
    public Clearance credentials;

    public UserTV(String row) {
        String[] delad = row.split(";");
        userName = delad[0];
        password = delad[1];
        credentials = mapClearance(delad[2]);

    }
//Ändrar så att jag kan ordna vad som visas för vilken behörighet
    //fungerade inte
    public UserTV(String userName, String password, Clearance credentials) {
        this.userName = userName;
        this.password = password;
        this.credentials = credentials;

    }

    public UserTV(String userName, String password, String credentials) {
        this.userName = userName;
        this.password = password;
        this.credentials = mapClearance(credentials);

    }



    public Clearance mapClearance(String str) {
        switch (str.toUpperCase()) {
            case "NONE":
                return Clearance.NONE;
            case "USER":
                return Clearance.USER;
            case "ADMIN":
                return Clearance.ADMIN;
            case "SUPERUSER":
                return Clearance.SUPERUSER;
        }
        return null;
    }

    public boolean loggedIn() {
        return (this.userName != null &&
                this.password != null &&
                this.credentials != null);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Clearance getCredentials() {
        return credentials;
    }

    public void setCredentials(Clearance credentials) {
        this.credentials = credentials;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
