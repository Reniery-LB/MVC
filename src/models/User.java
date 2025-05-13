package models;

public class User {
    public int id;
    public String name;
    public String email;
    public String username;
    public String company;
    
    public User(int id, String name, String email, String username, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.company = company;
    }
    
    public Object[] toArray() {
        return new Object[]{id, name, email, username, company};
    }
}