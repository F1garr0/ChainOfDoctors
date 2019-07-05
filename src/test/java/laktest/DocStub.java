package laktest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class DocStub extends Doc{

    DocStub(String name) {
        super(name);
    }

    @Override
    public String Recognize(String description) {
        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(FileReaderStub.readFile(""));
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
        if (!recipe.equals("")) {return recipe;}
        else {
            if(!this.next.isEmpty())
                for(ChainLink doctors:this.getAllNext()) {
                    recipe = doctors.Recognize(description);
                    if(!recipe.equals("Not found")) return recipe;
                    //( (Doc) doctors).getName();
                }

        }
        return "Not found";
    }
}
