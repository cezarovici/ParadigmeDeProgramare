package ro.miketuiasi.ro;

import com.google.gson.GsonBuilder

class JsonPrinter : Printer{
   override fun print(library: Library){
       val gsonPretty = GsonBuilder().setPrettyPrinting().create();

        print(gsonPretty.toJson(library))
    }
}
