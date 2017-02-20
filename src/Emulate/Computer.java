package Emulate;

/**
 * Created by wesley on 2017/2/20.
 */
public class Computer {
    int id;
    String ip;
    int port;
    String pass;
    String os;
    String des;

    public Computer(int id, String ip, int port, String pass, String os, String des) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.pass = pass;
        this.os = os;
        this.des = des;
    }
}
