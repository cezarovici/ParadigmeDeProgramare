open class Book(
   private var content: Content
) {
    fun getName():String{
        return this.getName()
    }
    fun getAuthor():String{
        return this.getAuthor()
    }
    fun getPublisher():String{
        return this.getPublisher()
    }
    fun getContent():String{
        return this.getContent()
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
        return "\n Book is " +
                getName() +
                " wrote by " +
                getAuthor() +
                "\n with this content " +
                getContent() +
                "\n\n Published by " +
                getPublisher()
    }
}