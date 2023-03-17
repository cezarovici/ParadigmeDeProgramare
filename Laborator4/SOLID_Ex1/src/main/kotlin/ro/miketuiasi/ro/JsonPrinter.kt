package ro.miketuiasi.ro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.miketuiasi.ro.Library;

public class JsonPrinter {
   fun print(library: Library){
       val gsonPretty = GsonBuilder().setPrettyPrinting().create();

        print(gsonPretty.toJson(library))
    }
}
