abstract public class Squares {

    private int id;
    private People positioned;

    abstract void SquaresAct(Player player);// example of usage abstract method to implement in sub classes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPositioned(People positioned) {
        this.positioned = positioned;
    }
}
