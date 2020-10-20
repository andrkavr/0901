import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ovajson {
    public static void main(String[] args){
        String someJson = "{ \"namn\": \"Jon\"}"; // Vi använder \" för att kunna ha " I en textsträng.

        try {
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(someJson);
            JSONObject jsonValues = (JSONObject)parsed;
            System.out.println(jsonValues.get("namn"));
            // Skriver ut Jon i konsollen.

            // För att få hela objektet som JSON
            System.out.println("Komplett objekt som JSON: " + jsonValues.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


