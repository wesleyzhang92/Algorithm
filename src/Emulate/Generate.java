package Emulate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by wesley on 2017/2/20.
 */
public class Generate {
    private void init(ArrayList<Computer> computers, ArrayList<User> users, ArrayList<Host> hosts) {
        computers.add(new Computer(1, "192.168.42.20", 5908, "PC1pass", "win7", "PC1"));
        computers.add(new Computer(2, "192.168.42.20", 5905, "PC2pass", "win7", "PC1"));
        computers.add(new Computer(3, "192.168.42.20", 5906, "PC3pass", "win7", "PC1"));
        computers.add(new Computer(4, "192.168.42.20", 5901, "PC4pass", "win7", "ADMIN"));
        users.add(new User("Admin", "admin"));
        users.add(new User("Alice", "pass1"));
        users.add(new User("Bob", "pass2"));
        users.add(new User("Carol", "pass3"));
        //hosts.add(new Host("10.10.21.1","Domain"));
        hosts.add(new Host("10.10.21.110", "Server 1"));
        hosts.add(new Host("10.10.21.109", "Server 2"));

    }

    private int getInnerId(ArrayList<InnerScenario> inners, Host host, User user) {
        for (InnerScenario inn : inners) {
            if (inn.host.equals(host.host) && inn.user.name.equals(user.name)) {
                return inn.id;
            }
        }

        return inners.size() + 1;
    }

    private int P_rand(double Lamda) {      // 泊松分布
        double x = 0, b = 1, c = Math.exp(-Lamda), u;
        do {
            u = Math.random();
            b *= u;
            if (b >= c)
                x++;
        } while (b >= c);
        return (int) x;
    }

    private Scenario visit(ArrayList<Computer> computers, ArrayList<User> users, ArrayList<Host> hosts,
                           ArrayList<InnerScenario> inners) {
        User user = users.get((int) (Math.random() * users.size()));
        Computer computer = computers.get((int) (Math.random() * computers.size()));
        while (computer.des.equals("ADMIN") && !user.name.equals("Admin")) {
            computer = computers.get((int) (Math.random() * computers.size()));
        }
        boolean isInner = (int) (Math.random() * 1000) % 2 == 0 ? true : false;
        InnerScenario inner = null;
        if (isInner) {
            Host host = hosts.get((int) (Math.random() * hosts.size()));
            while (host.des.equals("Server 2") && !user.name.equals("Admin")) {
                host = hosts.get((int) (Math.random() * hosts.size()));
            }
            int id = getInnerId(inners, host, user);
            if (id == inners.size() + 1) {
                inner = new InnerScenario(id, host.host, user, 250);
                inners.add(inner);
            }
        }
        int id = inner == null ? 0 : inner.id;
        System.out.print(computer.id + " " + user.name + " " + user.pass + " " + id + " ");
        return new Scenario(computer, user, 250, id);
    }

    public double exponential(Random rng, double mean) {
        return -mean * Math.log(rng.nextDouble());
    }

    public static void main(String[] args) {

        HashMap<Scenario, Integer> result = new HashMap<>();
        Generate g = new Generate();
        ArrayList<Computer> computers = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Host> hosts = new ArrayList<>();
        //ArrayList<Scenario> result = new ArrayList<>();
        ArrayList<InnerScenario> inners = new ArrayList<>();
        g.init(computers, users, hosts);
        long ts = 0;
        int size = g.P_rand(400);
        System.out.println("size = " + size);
        for (int i = 0; i < size; i++) {
            double z = Math.random();
            int x = (int) (-(1 / 1) * Math.log(z)) * 30000;
            //int x = (int)(-(1 / 0.5) * Math.log(z));
            ts += x;
            Scenario scenario = g.visit(computers, users, hosts, inners);
            if (result.containsKey(scenario)) {
                result.replace(scenario, result.get(scenario) + 1);
            } else {
                result.put(scenario, 1);
            }
            System.out.print(ts);
            System.out.println();
        }

        System.out.println("-------------------This id InnerScenario-------------------");
        for (InnerScenario inn : inners) {
            System.out.println(inn.id + " " + inn.host + " " + inn.user.name + " " + inn.user.pass + " " + inn.session);
        }

        System.out.println("-------------------This is Scenario-------------------");
        System.out.println("ID\tCid\tUser\tPassword\tInner\tTimes");
//        int i = 1;
//        for(Scenario s : result.keySet()){
//            System.out.println(i+"\t"+s.c.id+"\t"+s.user.getname()+"\t"+s.user.pass+"\t\t"+s.inner+"\t\t"+result.get(s));
//            i++;
//        }

    }
}
