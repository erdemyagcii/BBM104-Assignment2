public class OtherSquares extends Squares {
    private String type;

    OtherSquares(int id, String type) {
        setId(id);
        setType(type);
    }

    void SquaresAct(Player player) {// implemented from abstract class
        setPositioned(player);
        switch (this.type) {
            case "tax square":
                if (player.getWallet() >= 0) {
                    player.setWallet(player.getWallet() - 100);
                    Main.banker.setWallet(Main.banker.getWallet() + 100);
                    player.setProcessing(player.getName() + " paid tax");
                } else {
                    Main.key = false;
                    player.setProcessing(player.getName() + " goes bankrupt");
                }
                break;

            case "free parking":
                player.setPark(1);
                player.setProcessing(player.getName() + " has come to Free Parking area");
                break;

            case "jail":
                player.setBannedTour(3);
                player.setProcessing(player.getName() + " went to jail");
                break;

            case "go to jail":
                player.setLocation(11);
                for (Squares square : PropertyJsonReader.getSquares()) {
                    if (square.getId() == 11)
                        square.SquaresAct(player);
                }
                break;
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}
