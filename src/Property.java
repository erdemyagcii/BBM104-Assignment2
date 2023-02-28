abstract public class Property extends Squares {

    private final String name;
    private final int cost;
    private Player owner;
    private double rent;

    public Property(int id, String name, int cost) {
        this.setId(id);
        this.name = name;
        this.cost = cost;
    }

    @Override
    void SquaresAct(Player player) {
        setPositioned(player);
        if (owner == null && player.getWallet() >= cost) {
            owner = player;
            player.setWallet(player.getWallet() - cost);
            Main.banker.setWallet(Main.banker.getWallet() + cost);
            player.setProperties(this);
            player.setProcessing(player.getName() + " bought " + name);
        } else if (owner == null && player.getWallet() < cost) {
            Main.key = false;
            player.setProcessing(player.getName() + " goes bankrupt");
        } else if (owner != null) {
            if (player.getWallet() >= rent) {
                owner.setWallet((int) (owner.getWallet() + rent));
                player.setWallet((int) (player.getWallet() - rent));

                if (!player.getName().equals(owner.getName()))
                    player.setProcessing(player.getName() + " paid rent for " + getName());
                else
                    player.setProcessing(player.getName() + " has " + getName());
            } else {

                if (player.getName().equals(owner.getName()))
                    player.setProcessing(player.getName() + " has " + getName());
                else
                    Main.key = false;
                player.setProcessing(player.getName() + " goes bankrupt");
            }
        }
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setRent(int playersDiceNumber) {
        this.rent = 4 * playersDiceNumber;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Player getOwner() {
        return owner;
    }

}
