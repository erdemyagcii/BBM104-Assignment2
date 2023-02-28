public class Land extends Property {
    public Land(int id, String name, int cost) {
        super(id, name, cost);

        if (this.getCost() <= 2000)
            setRent(this.getCost() * (0.4));

        else if (this.getCost() <= 3000)
            setRent(this.getCost() * (0.3));

        else if (this.getCost() <= 4000)
            setRent(this.getCost() * (0.35));
    }

    @Override// example of polymorphism
    void SquaresAct(Player player) {
        super.SquaresAct(player);
    }
}
