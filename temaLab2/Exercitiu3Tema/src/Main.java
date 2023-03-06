import java.util.Scanner;
import org.graalvm.polyglot.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Numarul de aruncari ale monedei: ");
        int n = input.nextInt();

        System.out.print("Numarul de paturunjele dorite: ");
        int x = input.nextInt();

        if (x < 0) {
            x = 0;
        } else if (x > n) {
            x = n;
        }

        Context context = Context.newBuilder().allowAllAccess(true).build();

        context.eval("R", """
                pbinom <- function(n, x) {
                    p <- c()
                    for (i in 0:x) {
                        p[i+1] <- pbinom(i, n, 0.5)
                    }
                    return(p)
                }
                """);

        Value pBinom = context.getPolyglotBindings().getMember("pbinom");
        Value result = pBinom.execute(n, x);

        double[] probabilities = result.as(double[].class);

        System.out.println("Probabilitatea de a obtine cel mult " + x + " ori pajura din " + n + " aruncari:");

        for (int i = 0; i <= x; i++) {
            System.out.println(i + ": " + probabilities[i]);
        }

        context.close();
    }
}



