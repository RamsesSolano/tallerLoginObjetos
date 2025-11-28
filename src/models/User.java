package models;

public class User {

    private int id;
    private String name;
    private String lastName;
    private String password;
    private String typeLevel;
    private String email;

    public User() {
    }

    public User(int id, String name, String lastName, String password, String typeLevel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.typeLevel = typeLevel;
    }

    public User( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean authenticate(String inputPassword, String inputEmail) {
        System.out.println("Autenticando desde el modelo con email: " + this.email + " y contraseña: " + this.password);
        return this.password.equals(inputPassword) && this.email.equals(inputEmail);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(String typeLevel) {
        this.typeLevel = typeLevel;
    }

}
