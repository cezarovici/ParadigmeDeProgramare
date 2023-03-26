import org.graalvm.polyglot.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {

    private static void linearRegresion(String content){
        Context context = Context.newBuilder().allowAllAccess(true).build();
        context.eval("R", """
                # încarcă biblioteca "lattice" pentru plasarea graficelor
                library(lattice)
                         
                # citește setul de date din contentul parsat
                dataset <- read.csv(text = content)
                         
                # citește de la tastatură numele fișierului de output și calea de salvare
                nume_fisier <- readline(prompt = "Introduceți numele fișierului de output: ")
                cale_salvare <- readline(prompt = "Introduceți calea de salvare a fișierului: ")
                         
                # citește culorile pentru plasarea graficului
                culoare_puncte <- readline(prompt = "Introduceți culoarea punctelor (ex: 'red'): ")
                culoare_linie <- readline(prompt = "Introduceți culoarea liniei de regresie (ex: 'blue'): ")
                         
                # creează modelul de regresie liniară utilizând funcția lm()
                model <- lm(y ~ x, data = dataset)
                         
                # plasează graficul utilizând funcția xyplot() din biblioteca lattice
                grafic <- xyplot(y ~ x, data = dataset, col = culoare_puncte, pch = 19,
                                        panel = function(x, y, ...) {
                                          panel.xyplot(x, y, ...)
                                          panel.abline(model, col = culoare_linie)
                                        },
                                        xlab = "Variabila independenta", ylab = "Variabila dependenta")
                         
                # salvează graficul într-un fișier png utilizând funcția print()
                print(grafic, file = paste(cale_salvare, "/", nume_fisier, sep = ""),\s
                      type = "png", width = 800, height = 600, units = "px")
                """).execute(content);
    }
    private static String readFile(String pathToFile){
        Context function = Context.newBuilder().allowAllAccess(true).build();
        Value result = function.eval("python", """
                def readFile(path):
                    f = open(path,"r")
                                
                    return f.read()
                    
                readFile("""+pathToFile+")").execute();

        function.close();

        return result.asString();
    }

    public static void main(String[] args){
        String fileName = "dataset.txt";
        String content = readFile(fileName);

        linearRegresion(content);
    }
}
