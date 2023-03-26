import org.graalvm.polyglot.*;

import java.util.ArrayList;
import java.util.List;


class Main{

    private static List<Integer> generateRandomNumbers(){
        Context function = Context.newBuilder().allowAllAccess(true).build();
        Value result = function.eval("python",
                """
                        import random

                        def generate_random_numbers():
                            numbers = []
                            for i in range(20):
                                numbers.append(random.randint(1, 100))
                            return numbers
                            
                        generate_random_numbers()
                        """);
        return getIntegers(function, result);
    }
    private static List<Integer> processList(List<Integer> list) {
        Context context = Context.newBuilder().allowAllAccess(true).build();

        Value result = context.eval("R", """
                  f <- function(list) {
                  sorted <- sort(list)
                  trimmed <- sorted[4:16]
                  print(mean(trimmed)
                }
                """).execute(list);

        return getIntegers(context, result);
    }

    private static List<Integer> getIntegers(Context context, Value value) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < value.getArraySize(); i++) {
            Value item = value.getArrayElement(i);
            int intValue = item.asInt();
            result.add(intValue);
        }

        context.close();

        return result;
    }

    private static void displayList(List<Integer> list) {
        Context context = Context.newBuilder().allowAllAccess(true).build();
        Value bindings = context.getBindings("js");

        bindings.putMember("list", list);

        context.eval("js", "function displayList(list) { console.log(list); }");
        context.eval("js", "displayList(list);");
    }
    public static void main(String[] args){
        Context polyglot =  Context.create();

        List<Integer> list = generateRandomNumbers();
        System.out.println("Before sorting and trimming");
        displayList(list);

        System.out.println("After sorting and trimming");
        displayList(processList(list));

        polyglot.close();
    }
}