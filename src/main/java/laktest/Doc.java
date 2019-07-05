package laktest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class Doc extends ChainLink {

    private String name;
    Doc(String name) {
        this.name = name;
        this.next = new ArrayList<>();
    }

    public Doc() {
        this.next = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String Recognize(String description) {
        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(FileReader.readFile(this.name));
        }
        catch (ParseException e) {
            System.out.println("[ERROR]: Check json validation");
            e.printStackTrace();
        }

        JSONArray array = (JSONArray)object;
        String recipe="";
        if (array != null) {
            for (Object obj:array) {
                    if ( ((JSONObject)obj).get("symptoms").equals(description) )
                        recipe=(String)((JSONObject)obj).get("treatment");
            }
        }
        if (!recipe.equals("")) {return this.name+": "+recipe;}
        else {
            if(!this.next.isEmpty())
            for(ChainLink doctors:this.getAllNext()) {
                recipe = doctors.Recognize(description);
                if(!recipe.equals("Not found")) return recipe;
            }

        }
        return "Not found";
    }

}
