package ro.mike.tuiasi

interface Parser {
    public fun parse(text:String): Map<String,Any>
}