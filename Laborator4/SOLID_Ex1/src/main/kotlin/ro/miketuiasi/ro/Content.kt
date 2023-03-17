package ro.miketuiasi.ro

open class Content(
    private var autor: String,
    private var text: String,
    private var name: String,
    private var publisher: String
) {

    public fun getAutor(): String {
        return this.autor
    }

    public fun getText():String{
        return this.text
    }

    public fun getName():String{
        return this.name
    }

    public fun getPublisher():String{
        return this.publisher
    }

    public fun SetAutor(Autor:String){
        this.autor = Autor
    }
    public fun SetText(Text:String){
        this.text = Text
    }
    public fun SetName(Name: String){
        this.name = Name
    }
    public fun SetPublisher(Publisher: String){
        this.publisher = Publisher
    }
}