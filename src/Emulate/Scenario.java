package Emulate;

/**
 * Created by wesley on 2017/2/20.
 */
public class Scenario {
    Computer c;
    User user;
    int sessionTime;
    int inner;
    //int times;

    public Scenario(Computer c, User user, int sessionTime, int inner) {
        this.c = c;
        this.user = user;
        this.sessionTime = sessionTime;
        this.inner = inner;
        //this.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scenario scenario = (Scenario) o;

        if (sessionTime != scenario.sessionTime) return false;
        if (inner != scenario.inner) return false;
        if (c != null ? !c.equals(scenario.c) : scenario.c != null) return false;
        return user != null ? user.equals(scenario.user) : scenario.user == null;
    }

    @Override
    public int hashCode() {
        int result = c != null ? c.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + sessionTime;
        result = 31 * result + inner;
        return result;
    }
}
