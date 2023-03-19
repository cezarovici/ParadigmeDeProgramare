package ro.mike.tuiasi

import org.yaml.snakeyaml.Yaml

class YamlParser:Parser {
    public override fun parse(text: String): Map<String, Any> {
        return Yaml().load(text)
    }
}