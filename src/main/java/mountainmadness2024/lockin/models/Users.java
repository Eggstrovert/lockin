package mountainmadness2024.lockin.models;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int lockInTime;
    private String password; 

    public Users() { 
    }

    public Users(String name, String password, int lockInTime){
        this.name = name;
        this.password = password;
        this.lockInTime = lockInTime;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getlockInTime() {
        return lockInTime;
    }
    public void setlockInTime(int lockInTime) {
        this.lockInTime = lockInTime;
    }
    
}
