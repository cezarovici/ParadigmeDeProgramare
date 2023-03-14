class LibraryPrinter {
    fun printBooksRaw(books: Set<Book>){
        for (book in books){
            print("\n\nThis is a book")
            book.toString()
        }
    }

    fun printHTML(books: Set<Book>){

    }

    fun printJSON(books: Set<Book>){

    }
}