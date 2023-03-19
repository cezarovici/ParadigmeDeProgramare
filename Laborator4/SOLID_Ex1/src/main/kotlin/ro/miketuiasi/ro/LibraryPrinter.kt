package ro.miketuiasi.ro

class LibraryPrinter : Printer{
    override fun print(library: Library){
     val books = library.getBooks()

        for (book in books){
            print(book.toString())
        }
    }

}