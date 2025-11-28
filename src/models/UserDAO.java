package models;

public class UserDAO {

    private int id; 
    private String name; 
    private String lastName; 
    private String password;
    private String typeLevel; 
    private String email;
     

    public UserDAO() {
    }

    public UserDAO(
        int id, 
        String name, 
        String lastName, 
        String password, 
        String typeLevel,
        String email
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.typeLevel = typeLevel;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String toString() {
        return "UserDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", typeLevel='" + typeLevel + '\'' +
                '}';
    }

}
