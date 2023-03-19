package ro.mike.tuiasi;

import org.json.JSONObject

public class JsonParser:Parser {
    public override fun parse(text: String):Map<String,Any>{
        val jsonObject = JSONObject(text)
        val map = mutableMapOf<String,Any>()

        for (key in jsonObject.keys()){
            val value = jsonObject.get(key)
            map[key] = value;
        }

        return map
    }
}
