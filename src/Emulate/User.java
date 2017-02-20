package Emulate;

/**
 * Created by wesley on 2017/2/20.
 */
public class User {
    String name;
    String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getname() {
        while (this.name.length() < 5)
            this.name = this.name + " ";
        return this.name;
    }
}
