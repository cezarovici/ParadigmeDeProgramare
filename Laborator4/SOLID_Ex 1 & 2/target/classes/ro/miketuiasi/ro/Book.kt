package ro.miketuiasi.ro

import ro.miketuiasi.ro.Content

open class Book(
    private var content: Content,
    private var price: Double,
) {
    fun getName():String{
        return content.getName();
    }
    fun getAuthor():String{
        return content.getAutor()
    }
    fun getPublisher():String{
        return content.getPublisher()
    }
    fun getContent():String{
        return content.getText()
    }

    fun getPrice(): Double {
        return this.price;
    }

    fun setPrice(price: Double){
        this.price = price;
    }

    fun hasAuthor(author: String):Boolean{
        return author != ""
    }
    fun hasTitle(title: String):Boolean{
        return title!=""
    }

    fun isPublishedBy(publisher: String):Boolean{
        return getPublisher() == publisher
    }

     override fun toString(): String {
        return "\n ro.miketuiasi.ro.Book is " +
                getName() +
                " wrote by " +
                getAuthor() +
                "\n with this content " +
                getContent() +
                "\n Published by " +
                getPublisher()+
                "\n And cost: "+getPrice()
    }
}