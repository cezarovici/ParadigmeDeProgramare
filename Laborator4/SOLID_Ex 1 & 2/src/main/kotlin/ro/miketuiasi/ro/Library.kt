package ro.miketuiasi.ro

import ro.miketuiasi.ro.Book

class Library (
   private var books: MutableSet<Book>
){
    fun getBooks():Set<Book>{
       return this.books
    }

    fun addBook(book: Book){
        this.books.add(book)
    }

    fun findByAuthor(authorSearched: String): Book? {
        for(book in books){
            if (book.getAuthor() == authorSearched){
                return book
            }
        }

        return null
    }

    fun findByName(nameSearched: String) : Book?{
        for(book in books){
            if (book.getName() == nameSearched){
                return book
            }
        }

        return null
    }

    fun findAllByPublisher(publisherSearched: String): Book?{
        for(book in books){
            if (book.getPublisher() == publisherSearched){
                return book
            }
        }

        return null
    }
}