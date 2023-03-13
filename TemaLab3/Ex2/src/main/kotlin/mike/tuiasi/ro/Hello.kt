package mike.tuiasi.ro

import java.io.File

fun main(args: Array<String>) {
  val eBook = File("src/eBook.txt")
  val outputFile = File("src/output")
  var text = eBook.readText()


     text = text.replace(Regex("\\s+"), " ")

   //  text = text.replace(Regex("\\n+"), "\n")

     text = text.replace(Regex("\\s*\\d+\\s*"), " ")

    // replace author
    text = text.replace(Regex("\\s+(de\\s+)[A-Z][a-z]+\\s+[A-Z][a-z]+\\s+"), " ")

    // replace cap
    text = text.replace(Regex("\\s+Capitolul\\s+[IVXLCM]+\\s+"), " ")

    // replace diactritice
    text = text.replace("ș", "s").replace("ț", "t")


    outputFile.writeText(text)
}

