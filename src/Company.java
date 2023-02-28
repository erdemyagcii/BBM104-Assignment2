public class Company extends Property {
    public Company(int id, String name, int cost) {
        super(id, name, cost);
    }

    @Override//example of polymorphism
    void SquaresAct(Player player) {
        setRent(player.getDice());
        super.SquaresAct(player);
    }

}
