import org.graalvm.polyglot.*;

import java.util.ArrayList;
import java.util.List;


class Main{

    private static List<Integer> convertToList(Value value) {
        List<Integer> result = new ArrayList<>();
        Value lengthValue = Value.asValue(value.getArraySize());

        int length = lengthValue.asInt();

        for (int i = 0; i < length; i++) {
            Value item = value.getArrayElement(i);
            int intValue = item.asInt();
            result.add(intValue);
        }

        return result;
    }

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
                        """);

        return convertToList(result);
    }

    public static void main(String[] args){

    }
}