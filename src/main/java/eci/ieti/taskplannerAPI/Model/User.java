package eci.ieti.taskplannerAPI.Model;

public class User {
    private String name;
    private String eMail;
    private String id;

    public User(String name, String eMail, String id) {
        this.name = name;
        this.eMail = eMail;
        this.id = id;
    }

    public User(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
