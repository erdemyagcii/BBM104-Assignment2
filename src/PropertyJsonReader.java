import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

public class PropertyJsonReader {

    private static ArrayList<Squares> squares = new ArrayList<>();

    public static ArrayList<Squares> getSquares() {
        return squares;
    }

    public PropertyJsonReader() {
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("property.json")) {
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray Land = (JSONArray) jsonfile.get("1");
            for (Object i : Land) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares.add(new Land(id, name, cost));

            }
            JSONArray RailRoad = (JSONArray) jsonfile.get("2");
            for (Object i : RailRoad) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares.add(new Railroads(id, name, cost));
            }

            JSONArray Company = (JSONArray) jsonfile.get("3");
            for (Object i : Company) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares.add(new Company(id, name, cost));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CommunityChest communityChest3 = new CommunityChest(3);
        CommunityChest communityChest18 = new CommunityChest(18);
        CommunityChest communityChest34 = new CommunityChest(34);
        Chance chance8 = new Chance(8);
        Chance chance23 = new Chance(23);
        Chance chance37 = new Chance(37);
        OtherSquares go = new OtherSquares(1, "go");
        OtherSquares jail = new OtherSquares(11, "jail");
        OtherSquares freeParking = new OtherSquares(21, "free parking");
        OtherSquares goJail = new OtherSquares(31, "go to jail");
        OtherSquares tax5 = new OtherSquares(5, "tax square");
        OtherSquares tax39 = new OtherSquares(39, "tax square");
        Collections.addAll(PropertyJsonReader.squares, communityChest3, communityChest18, communityChest34, chance8, chance23, chance37, go, jail, freeParking, goJail, tax5, tax39);
    }

}