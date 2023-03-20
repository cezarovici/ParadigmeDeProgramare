package ro.miketuiasi.ro


fun main(args: Array<String>) {
  val content = Content(autor = "Apetroaei Cezar", text = "Documentatie joc", name="AllStars", publisher = "Viorel");
  val book1 = Book(content,30.4);
  val book2 = Book(content,50.10);

  val books = mutableSetOf<Book>(book1,book2);
  val library = Library(books);

  JsonPrinter().print(library)
  LibraryPrinter().print(library)
}