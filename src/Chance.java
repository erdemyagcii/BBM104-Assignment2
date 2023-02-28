public class Chance extends Squares {

    Chance(int id) {//mainde squares arraylistine eklemeleri yaparsın
        setId(id);
    }

    @Override//example of polymorphism
    void SquaresAct(Player player) {
        setPositioned(player);
        switch (ListJsonReader.chances.get(0)) {
            case "Advance to Go (Collect $200)":
                player.setLocation(1);
                player.setWallet(player.getWallet() + 200);
                Main.banker.setWallet(Main.banker.getWallet() - 200);
                ListJsonReader.chances.remove(0);
                ListJsonReader.chances.add("Advance to Go (Collect $200)");
                player.setProcessing(player.getProcessing() + player.getName() + " draw chance - Advance to Go (Collect $200)");
                break;

            case "Advance to Leicester Square":
                int index = 0;
                for (int i = 0; i < PropertyJsonReader.getSquares().size(); i++) {
                    if (PropertyJsonReader.getSquares().get(i).getId() == 27)
                        index = i;
                }
                if (player.getLocation() > 27) {
                    player.setWallet(player.getWallet() + 200);
                    Main.banker.setWallet(Main.banker.getWallet() - 200);
                }
                player.setLocation(27);
                PropertyJsonReader.getSquares().get(index).SquaresAct(player);
                ListJsonReader.chances.remove(0);
                ListJsonReader.chances.add("Advance to Leicester Square");
                player.setProcessing(player.getName() + " draw chance - Advance to Leicester Square " + player.getProcessing());
                break;

            case "Go back 3 spaces":
                player.setLocation(player.getLocation() - 3);
                for (Squares square : PropertyJsonReader.getSquares()) {

                    if (square.getId() == player.getLocation())
                        square.SquaresAct(player);

                }
                ListJsonReader.chances.remove(0);
                ListJsonReader.chances.add("Go back 3 spaces");
                player.setProcessing(player.getName() + " draw chance - Go back 3 spaces" + player.getProcessing());
                break;

            case "Pay poor tax of $15":
                if ( player.getWallet() < 15) {
                    Main.key = false;
                    player.setProcessing(player.getName() + " goes bankrupt");
                }
                else {
                    player.setWallet(player.getWallet() - 15);
                    Main.banker.setWallet(Main.banker.getWallet() + 15);
                    ListJsonReader.chances.remove(0);
                    ListJsonReader.chances.add("Pay poor tax of $15");
                    player.setProcessing(player.getName() + " draw chance - Pay poor tax of $15");
                }
                break;

            case "Your building loan matures - collect $150":
                player.setWallet(player.getWallet() + 150);
                Main.banker.setWallet(Main.banker.getWallet() - 150);
                ListJsonReader.chances.remove(0);
                ListJsonReader.chances.add("Your building loan matures - collect $150");
                player.setProcessing(player.getName() + " draw chance - Your building loan matures - collect $150");
                break;

            case "You have won a crossword competition - collect $100":
                player.setWallet(player.getWallet() + 100);
                Main.banker.setWallet(Main.banker.getWallet() - 100);
                ListJsonReader.chances.remove(0);
                ListJsonReader.chances.add("You have won a crossword competition - collect $100");
                player.setProcessing(player.getName() + " draw chance - You have won a crossword competition - collect $100");
                break;

        }
    }
}
