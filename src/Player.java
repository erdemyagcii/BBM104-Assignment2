import java.util.ArrayList;

public class Player extends People {
    private int location; //1 between 40
    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Railroads> railroads = new ArrayList<>();
    private int bannedTour;
    private int dice;
    private String processing;
    private final String name;
    private int park;


    Player(String name) {
        super(15000);
        this.location = 1;
        this.bannedTour = 0;
        this.name = name;
        this.processing = "";
        this.park = 0;
    }

    void PlayersAct(int diceNumber) {
        int startLocation = this.location;
        location += diceNumber;
        if ((location - 40) > 0)
            location -= 40;

        int finalLocation = location;
        if (finalLocation < startLocation) {
            setWallet(getWallet() + 200);
            Main.banker.setWallet(Main.banker.getWallet() - 200);
        }
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(Property property) {
        this.properties.add(property);
    }

    public int getDice() {
        return dice;
    }

    public ArrayList<Railroads> getRailroads() {
        return railroads;
    }

    public int getBannedTour() {
        return bannedTour;
    }

    public void setBannedTour(int bannedTour) {
        this.bannedTour = bannedTour;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getName() {
        return name;
    }

    public int getPark() {
        return park;
    }

    public void setPark(int park) {
        this.park = park;
    }
}
