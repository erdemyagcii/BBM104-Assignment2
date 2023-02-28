import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static Player player1 = new Player("Player 1");
    static Player player2 = new Player("Player 2");
    static Banker banker = new Banker();
    static boolean key = true;// I used this field to check if there is a player went bankrupt
    static String showWord;
    static String path;

    public static void show() {
        String winner;
        String player1assets = "";
        String player2assets = "";
        for (Property property : player1.getProperties())
            player1assets = player1assets + property.getName() + ", ";
        for (Property property : player2.getProperties())
            player2assets = player2assets + property.getName() + ", ";
        try {
            player1assets = player1assets.substring(0, player1assets.length() - 2);
            player2assets = player2assets.substring(0, player2assets.length() - 2);
        } catch (StringIndexOutOfBoundsException ignored) {
        }

        if (player1.getWallet() > player2.getWallet())
            winner = "Player 1";
        else
            winner = "Player 2";

        showWord = "-----------------------------------------------------------------------------------------------------------\n";
        showWord = showWord + "Player 1\t" + player1.getWallet() + "\t" + "have: " + player1assets + "\n";
        showWord = showWord + "Player 2\t" + player2.getWallet() + "\t" + "have: " + player2assets + "\n";
        showWord = showWord + "Banker " + banker.getWallet() + "\n";
        showWord = showWord + "Winner " + winner + "\n";

        if (key == true)
            showWord = showWord + "-----------------------------------------------------------------------------------------------------------\n";
        else
            showWord = showWord + "-----------------------------------------------------------------------------------------------------------";
    }

    public static void Play(Player player, String dice) {
        if (player.getBannedTour() != 0) {
            player.setProcessing(player.getName() + " in jail (count=" + (4 - player.getBannedTour()) + ")");//get processing silebilirsin gibi
            showWord = player.getName() + "\t" + dice + "\t" + player.getLocation() + "\t" + player1.getWallet() + "\t" + player2.getWallet() + "\t" + player.getProcessing() + "\n";
            player.setProcessing("");
            player.setBannedTour(player.getBannedTour() - 1);
        }
        else if(player.getPark() == 1){
            player.setProcessing(player.getName() + " is in Free Parking");
            showWord = player.getName() + "\t" + dice + "\t" + player.getLocation() + "\t" + player1.getWallet() + "\t" + player2.getWallet() + "\t" + player.getProcessing() + "\n";
            player.setProcessing("");
            player.setPark(0);
        }
        else {
            player.PlayersAct(Integer.parseInt(dice));
            for (Squares square : PropertyJsonReader.getSquares()) {
                if (square.getId() == player.getLocation())
                    square.SquaresAct(player);
            }
            showWord = player.getName() + "\t" + dice + "\t" + player.getLocation() + "\t" + player1.getWallet() + "\t" + player2.getWallet() + "\t" + player.getProcessing() + "\n";
            player.setProcessing("");
        }
    }

    public static void main(String[] args) throws IOException {
        path = args[0];
        new PropertyJsonReader();// It is for creating and adding objects in PropertyJsonReader Class
        new ListJsonReader();// Same with upward
        Commands.OwnMethod();
        File outputTxt = new File("monitoring.txt");
        FileWriter fileWriter = new FileWriter(outputTxt, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String[] i : Commands.getCommands()) {
            if (key == true) {
                if (i[0].equals("Player 1")) {
                    Play(player1, i[1]);
                    bufferedWriter.write(showWord);
                } else if (i[0].equals("Player 2")) {
                    Play(player2, i[1]);
                    bufferedWriter.write(showWord);
                } else {
                    show();
                    bufferedWriter.write(showWord);
                }
            } else
                break;
        }
        show();
        bufferedWriter.write(showWord);
        bufferedWriter.close();
    }
}
