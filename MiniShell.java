import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiniShell {

    public static void main(String[] args) throws IOException {
        // here im reading the input from the user using terminal system.in reads the
        // data in bytes and
        // inputstream reader converts this byte in utf-8 charcater by character and
        // this buffer reader stores
        // characters in buffers this make reading more efficent

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the my project 'My shell' ");
        System.out.println("type 'ByeBye' to exit the shell ");
        while (true) {
            System.out.println("MyShell>>");
            // here im reading the whole line enterdin terminal
            // using my reader which i have made in line no. 13

            String command = reader.readLine();
            if (command == null || command.equalsIgnoreCase("ByeBye")) {
                System.out.println("Have a nuce day buddy..");
                break;

            }
            runCommand(command);
        }

    }

    private static void runCommand(String command) {
        try {
            String[] splittingCharacters = command.trim().split("\\s+");
            // now creating a new process using Procesbuilder class
            ProcessBuilder p1 = new ProcessBuilder(splittingCharacters);
            // this will help me to use the same console for input/output
            p1.inheritIO();
            Process proces = p1.start();
            proces.waitFor();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}
