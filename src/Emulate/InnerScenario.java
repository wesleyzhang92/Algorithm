package Emulate;

/**
 * Created by wesley on 2017/2/20.
 */
public class InnerScenario {

    int id;
    String host;
    User user;
    int session;

    public InnerScenario(int id, String host, User user, int session) {
        this.id = id;
        this.host = host;
        this.user = user;
        this.session = session;
    }
}
