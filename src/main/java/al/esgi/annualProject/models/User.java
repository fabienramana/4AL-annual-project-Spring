package al.esgi.annualProject.models;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="user")
@Data
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "firstname", nullable = true)
    private String firstname;
    
    @Column(name = "lastname", nullable = true)
    private String lastname;
    
    @NotNull
    @Column(name="user_id_android", nullable = false)
    private String userIdAndroid;
    
    @Column(name="gender", nullable = true)
    private String gender;

    public User() {
    }

    public User(String username, String firstname, String lastname,
                String gender, String userIdAndroid) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.userIdAndroid = userIdAndroid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserIdAndroid() {
        return userIdAndroid;
    }

    public void setUserIdAndroid(String userIdAndroid) {
        this.userIdAndroid = userIdAndroid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}