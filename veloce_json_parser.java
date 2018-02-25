public class JSONParser{
    public static String[] jsonParser(String jsonStr){
        jsonStr = jsonStr.substring(jsonStr.indexOf('['))
        jsonStr = jsonStr.substring(jsonStr.indexOf('['))
        jsonStr = jsonStr.substring(0, jsonStr.indexOf(']'))

        jsonStr = jsonStr.split("},{");
        for (int i=0; i<jsonStr.length(); i++){
            String[] items = jsonStr[i].split(",");
            for (int j=0; j<items.length(); j++){
                String[] item = items[j].split(":");
                items[j] = item
            }
            jsonStr[i] = items
        }
        return jsonStr
    }
}