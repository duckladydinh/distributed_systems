import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws Exception {
        Process cmdServer = Runtime.getRuntime().exec("java -cp server/ main");
        Process cmdClient = Runtime.getRuntime().exec("java -cp client/ main");
        System.out.println(
                "\tTCP sockets experiment by sending 100,000 packets\n" +
                "\tand the server receives all packets that are sent\n" +
                "\t-------------------------------------------------"
        );
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(cmdServer.getInputStream()));
        String line = "";
        while ((line = reader.readLine())!= null) {
            System.out.println(line);
        }

    }
}
