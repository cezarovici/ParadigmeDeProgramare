package ro.mike.tuiasi

import jdk.jfr.ContentType
import khttp.get
import khttp.responses.Response


class Crawler(
    private val url :String
) {
    private fun getResource() :Response{
        return get(url)
    }

    public fun processContent(contentType: String):Map<String,Any>{
        val response = getResource()
        val body = response.text

        return when (contentType) {
            "json" -> JsonParser().parse(body)
            // "xml" -> XmlParser().parse(body)
            "yaml" -> YamlParser().parse(body)
            else -> emptyMap()
        }
    }
}