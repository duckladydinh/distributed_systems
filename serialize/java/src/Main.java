import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Process cmdServer = Runtime.getRuntime().exec("java server");
        Process cmdClient = Runtime.getRuntime().exec("java client");
        System.out.println(
                        "\tExperiment with Serialization in Java TCP socket\n" +
                        "\tClient sends 2 Book objects and the server gets!\n" +
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
