public class CommunityChest extends Squares {

    CommunityChest(int id) {
        setId(id);
    }

    @Override//example of polymorphism
    void SquaresAct(Player player) {
        setPositioned(player);
        switch (ListJsonReader.communityChests.get(0)) {
            case "Advance to Go (Collect $200)":
                player.setLocation(1);
                player.setWallet(player.getWallet() + 200);
                Main.banker.setWallet(Main.banker.getWallet() - 200);
                ListJsonReader.communityChests.remove(0);
                ListJsonReader.communityChests.add("Advance to Go (Collect $200)");
                player.setProcessing(player.getName() + " draw Community Chest - Advance to Go (Collect $200)");
                break;

            case "Bank error in your favor - collect $75":
                player.setWallet(player.getWallet() + 75);
                Main.banker.setWallet(Main.banker.getWallet() - 75);
                ListJsonReader.communityChests.remove(0);
                ListJsonReader.communityChests.add("Bank error in your favor - collect $75");
                player.setProcessing(player.getName() + " draw Community Chest - Bank error in your favor - collect $75");
                break;

            case "Doctor's fees - Pay $50":
                if ( player.getWallet() < 50) {
                    Main.key = false;
                    player.setProcessing(player.getName() + " goes bankrupt");
                }
                else {
                    player.setWallet(player.getWallet() - 50);
                    Main.banker.setWallet(Main.banker.getWallet() + 50);
                    ListJsonReader.communityChests.remove(0);
                    ListJsonReader.communityChests.add("Doctor's fees - Pay $50");
                    player.setProcessing(player.getName() + " draw Community Chest - Doctor's fees - Pay $50 ");
                }
                break;

            case "It is your birthday Collect $10 from each player":
                if (Main.player1.equals(player)) {
                    if (Main.player2.getWallet() < 10) {
                        Main.key = false;
                        player.setProcessing(player.getName() + " goes bankrupt");
                    } else {
                        Main.player2.setWallet(Main.player2.getWallet() - 10);
                        player.setWallet(player.getWallet() + 10);}}
                else {
                    if (Main.player2.getWallet() < 10) {
                        Main.key = false;
                        player.setProcessing(player.getName() + " goes bankrupt");
                    } else {
                        Main.player2.setWallet(Main.player2.getWallet() - 10);
                        player.setWallet(player.getWallet() + 10);}}
                ListJsonReader.communityChests.remove(0);
                if(Main.key == true) {
                    ListJsonReader.communityChests.add("It is your birthday Collect $10 from each player");
                    player.setProcessing(player.getName() + " draw Community Chest - It is your birthday Collect $10 from each player");}
                break;

            case "Grand Opera Night - collect $50 from every player for opening night seats":
                if (Main.player1.equals(player)) {
                    if (Main.player2.getWallet() < 50) {
                        Main.key = false;
                        player.setProcessing(player.getName() + " goes bankrupt");
                    } else {
                        Main.player2.setWallet(Main.player2.getWallet() - 50);
                        player.setWallet(player.getWallet() + 50);}}
                else {
                    if (Main.player2.getWallet() < 50) {
                        Main.key = false;
                        player.setProcessing(player.getName() + " goes bankrupt");
                    } else {
                        Main.player2.setWallet(Main.player2.getWallet() - 50);
                        player.setWallet(player.getWallet() + 50);}}
                ListJsonReader.communityChests.remove(0);
                if(Main.key == true) {
                    ListJsonReader.communityChests.add("Grand Opera Night - collect $50 from every player for opening night seats");
                    player.setProcessing(player.getName() + " draw Community Chest - Grand Opera Night - collect $50 from every player for opening night seats");}
                break;

            case "Income Tax refund - collect $20":
                player.setWallet(player.getWallet() + 20);
                Main.banker.setWallet(Main.banker.getWallet() - 20);
                ListJsonReader.communityChests.remove(0);
                ListJsonReader.communityChests.add("Income Tax refund - collect $20");
                player.setProcessing(player.getName() + " draw Community Chest - Income Tax refund - collect $20");
                break;

            case "Life Insurance Matures - collect $100":
                player.setWallet(player.getWallet() + 100);
                Main.banker.setWallet(Main.banker.getWallet() - 100);
                ListJsonReader.communityChests.remove(0);
                ListJsonReader.communityChests.add("Life Insurance Matures - collect $100");
                player.setProcessing(player.getName() + " draw Community Chest - Life Insurance Matures - collect $100");
                break;

            case "Pay Hospital Fees of $100":
                if ( player.getWallet() < 100) {
                    Main.key = false;
                    player.setProcessing(player.getName() + " goes bankrupt");
                }
                else {
                    player.setWallet(player.getWallet() - 100);
                    Main.banker.setWallet(Main.banker.getWallet() + 100);
                    ListJsonReader.communityChests.remove(0);
                    ListJsonReader.communityChests.add("Pay Hospital Fees of $100");
                    player.setProcessing(player.getName() + " draw Community Chest - Pay Hospital Fees of $100");
                }
                break;

            case "Pay School Fees of $50":
                if ( player.getWallet() < 50) {
                    Main.key = false;
                    player.setProcessing(player.getName() + " goes bankrupt");
                }
                else {
                    player.setWallet(player.getWallet() - 50);
                    Main.banker.setWallet(Main.banker.getWallet() + 50);
                    ListJsonReader.communityChests.remove(0);
                    ListJsonReader.communityChests.add("Pay School Fees of $50");
                    player.setProcessing(player.getName() + " draw Community Chest - Pay School Fees of $50");
                }
                break;

            case "You inherit $100":
                player.setWallet(player.getWallet() + 100);
                Main.banker.setWallet(Main.banker.getWallet() - 100);
                ListJsonReader.communityChests.remove(0);
                ListJsonReader.communityChests.add("You inherit $100");
                player.setProcessing(player.getName() + " draw Community Chest - You inherit $100");
                break;

            case "From sale of stock you get $50":
                player.setWallet(player.getWallet() + 50);
                Main.banker.setWallet(Main.banker.getWallet() - 50);
                ListJsonReader.communityChests.remove(0);
                ListJsonReader.communityChests.add("From sale of stock you get $50");
                player.setProcessing(player.getName() + " draw Community Chest - From sale of stock you get $50");
                break;
        }
    }
}
