package org.example.models.user;

public class User {
    protected String userid;
    protected String name;
    protected String email;
    protected String phoneNumber;

    public User(String id, String name, String email, String phoneNumber) {
        this.userid = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() { return userid; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
}
