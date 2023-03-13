//utilizam File din Java.io pentru a deschide fisierul text
import org.example.RHistogram
import java.io.File

fun GetUniqueWordCount(all_words : List<String>) : MutableMap<String, Int> {
    //functia pentru calculul cuvintelor unice
    val result = mutableMapOf<String,Int>()
    for (word in all_words){
        val count = result.getOrDefault(word,0)
        result[word] = count+1
    }

    return result
}

fun GetUniqueCharCount(all_chars : List<String>) : MutableMap<Char, Int> {
    //functia pentru calculul caracterelor unice
    val result = mutableMapOf<Char, Int>()

    for (word in all_chars){
        for (char in word){
            val count = result.getOrDefault(char,0)
            result[char] = count+1
        }
    }

    return result
}

fun SortByHitCount(items : MutableMap<Char, Int>, how: Boolean) : MutableMap<Char, Int>{
    //functia de sortare a caracterelor, dupa valoare (frecventa), atat crescator cat si descrescator, in functie de how
    val result = mutableMapOf<Char, Int>()
    val pairList = items.toList()

    val sortedList = if (how) {
        pairList.sortedBy { it.second }
    } else {
        pairList.sortedByDescending { it.second }
    }

    for (pair in sortedList) {
        result[pair.first] = pair.second
    }

    return result
}


fun displayPairs(items: MutableMap<Char, Int>) {
   val sortedAscending = SortByHitCount(items,true)
    for (pair in sortedAscending) {
        println("${pair.key} -> ${pair.value}")
    }

    val sortedDescending = SortByHitCount(items,false)
    for (pair in sortedDescending) {
        println("${pair.key} -> ${pair.value}")
    }
}


//functia main()
fun main(args : Array<String>){
    //citim liniile din fisier
    val currentDir = System.getProperty("user.dir")
    println("Current directory is: $currentDir")

    val lines = File("src/Fisier.txt").reader().readText()
    //construim un array de cuvinte, seprand prin spatiu
    val words = lines.split(" ")

    //eliminam semnele de punctuatie de pe marginile cuvintelor
    val trim_words = mutableListOf<String>()
    words.forEach {
        val filter = it.trim(',','.','"','?', '!')
        trim_words += filter.toLowerCase()
        print(filter + " ")
    }
    println("\n")

    //construim o lista cu toate caracterele folosite 'A..Z'
    val chars = mutableListOf<String>()
    trim_words.forEach {
        for (c in it){
            if (c in 'a'..'z' || c in 'A'..'Z') {
                chars += c.toUpperCase().toString()
                print(c.toUpperCase())
            }
        }
    }
    println("\n")

    val newChars = GetUniqueCharCount(chars)
    val charsMap = SortByHitCount(newChars,true)
    val sortedCharsList = SortByHitCount(charsMap, true).toList() + SortByHitCount(charsMap, false).toList()

    displayPairs(charsMap)
    print(sortedCharsList)
    //Pentru constructia histogramelor, R foloseste un mecanism prin care asociaza caracterelor unice, numarul total de aparitii (frecventa)
    // 1. Construiti in Kotlin acelasi mecanism de masurare a frecventei elementelor unice si afisati cuvintele unice din trim_words
    // 2. Construiti in Kotlin acelasi mecanism de masurare a frecventei elementelor unice si afisati caracterele unice din chars
    // 3. Pentru frecventele caracterelor unice caclulate anterior si
    //      A. Afisati perechile (frecventa -> Caracter) sortate crescator si descrescator
    //      B. afisati graficele variatiei de frecventa sortate anterior crescator si descrescator si concatenati-le intr-un grafic de puncte

    //construim histograma pentru cuvinte
    RHistogram.BuildHistogram(trim_words.toTypedArray(), "Words", true)
    //construim histograma pentru caractere
    RHistogram.BuildHistogram(chars.toTypedArray(), "Chars", true)

    RHistogram.BuildHistogram(sortedCharsList.toTypedArray()," New",false)
}