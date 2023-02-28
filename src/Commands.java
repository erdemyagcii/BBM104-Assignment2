import java.io.*;
import java.util.ArrayList;

public class Commands {

    private static ArrayList<String[]> commands = new ArrayList<>();

    public static ArrayList<String[]> getCommands() {
        return commands;
    }

    static void OwnMethod() throws IOException {
        File commandTxt = new File(Main.path);
        FileReader rCommandTxt = new FileReader(commandTxt);
        BufferedReader bRCommandTxt = new BufferedReader(rCommandTxt);
        String line;
        String[] lineList;
        while ((line = bRCommandTxt.readLine()) != null) {
            lineList = line.split(";");
            commands.add(lineList);
        }
        bRCommandTxt.close();
    }
}
