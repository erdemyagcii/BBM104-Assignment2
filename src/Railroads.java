public class Railroads extends Property {
    public Railroads(int id, String name, int cost) {
        super(id, name, cost);
    }

    @Override
    void SquaresAct(Player player) {

        if (this.getOwner() != null)
            setRent(25 * getOwner().getRailroads().size());

        super.SquaresAct(player);
    }
}
