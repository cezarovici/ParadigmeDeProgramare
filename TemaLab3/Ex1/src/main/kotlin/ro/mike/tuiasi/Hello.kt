package ro.mike.tuiasi
import org.jsoup.Jsoup

class RSSElement(val title: String,val description: String,val link:String,val publicationDate: String){
    fun print(){
        print("\n\nYou can find article named $title wrote on $publicationDate at $link and this is something about it $description")
    }
}

class RSSFeed(val title: String,val description: String,val link:String,val publicationDate: String,var elements: List<RSSElement>){
    fun print(){
        print("\nYou can find this main article named $title wrote on $publicationDate at $link and this is something about it \n\n $description")
        print("\nThose are subarticles")
        for (each in elements){
            each.print()
        }
    }
}


fun main(args: Array<String>) {
    val doc = Jsoup.connect("http://rss.cnn.com/rss/edition.rss").get()

    val rssElements = doc.select("item").map {
        val title = it.select("title").text()
        val description = it.select("description").text()
        val link = it.select("link").text()
        val publicationDate = it.select("pubDate").text()


        RSSElement(title, description,link, publicationDate)
    }
    val title = doc.select("title")[0].text()
    val description = doc.select("description")[0].text()
    val link = doc.select("link")[0].text()
    val publicationDate = doc.select("pubDate")[0].text()


    val rssFeed = RSSFeed(title,description,link,publicationDate,rssElements)

    rssFeed.print()
}

