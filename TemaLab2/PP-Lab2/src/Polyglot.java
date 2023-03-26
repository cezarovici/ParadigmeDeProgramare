//import libraria principala polyglot din graalvm
import org.graalvm.polyglot.*;
import java.util.Arrays;
import java.util.*;

//clasa principala - aplicatie JAVA
class Polyglot {
    //metoda privata pentru conversie low-case -> up-case folosind functia toupper() din R
    private static String RToUpper(String token){
        //construim un context care ne permite sa folosim elemente din R
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        //folosim o variabila generica care va captura rezultatul excutiei funcitiei R, toupper(String)
        //pentru aexecuta instructiunea I din limbajul X, folosim functia graalvm polyglot.eval("X", "I");
        Value result = polyglot.eval("R", "toupper(\""+token+"\");");
        //utilizam metoda asString() din variabila incarcata cu output-ul executiei pentru a mapa valoarea generica la un String
        String resultString = result.asString();
        // inchidem contextul Polyglot
        polyglot.close();

        return resultString;
    }

    //metoda privata pentru evaluarea unei sume de control simple a literelor unui text ASCII, folosind PYTHON
    private static int SumCRC(String token){
        //construim un context care ne permite sa folosim elemente din PYTHON
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        //folosim o variabila generica care va captura rezultatul excutiei functiei PYTHON, sum()
        //avem voie sa inlocuim anumite elemente din scriptul pe care il construim spre evaluare, aici token provine din JAVA, dar va fi interpretat de PYTHON
        Value result = polyglot.eval("python", "" +
                "def sumPolynomial(word):\n" +
                "    word = word[1:-1]\n"+
                "    sum = 0\n" +
                "    for i, byte in enumerate(word):\n" +
                "        if i > 5:\n" +
                "            break\n" +
                "        sum = sum + i*byte\n" +
                "    return sum\n" +
                "sumPolynomial(" + Arrays.toString(token.getBytes()) + ")");

        //utilizam metoda asInt() din variabila incarcata cu output-ul executiei, pentru a mapa valoarea generica la un Int
        int resultInt = result.asInt();
        // inchidem contextul Polyglot
        polyglot.close();

        return resultInt;
    }

    //functia MAIN
    public static void main(String[] args) {
        //construim un context pentru evaluare elemente JS
        Context polyglot = Context.create();
        //construim un array de string-uri, folosind cuvinte din pagina web:  https://chrisseaton.com/truffleruby/tenthings/
        Value array = polyglot.eval("js", "[\"If\",\"we\",\"run\",\"o\",\"extra\"]");
        //pentru fiecare cuvant, convertim la upcase folosind R si calculam suma de control folosind PYTHON
        Map<Integer, List<String>> wordsByLength = new HashMap<>();

        for (int i = 0; i < array.getArraySize(); i++) {
            String element = array.getArrayElement(i).asString();
            String upper = RToUpper(element);
            int crc = SumCRC(upper);

            // check if the length is already in the dictionary
            if (!wordsByLength.containsKey(crc)) {
                // if not, add a new list for this length
                wordsByLength.put(crc, new ArrayList<>());
            }

            // add the word to the list for this length
            wordsByLength.get(crc).add(upper);
        }

            // print the words for each length
        for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
            int length = entry.getKey();
            List<String> words = entry.getValue();
            System.out.println(length + ": " + words);
        }
        // inchidem contextul Polyglot
        polyglot.close();
    }
}

