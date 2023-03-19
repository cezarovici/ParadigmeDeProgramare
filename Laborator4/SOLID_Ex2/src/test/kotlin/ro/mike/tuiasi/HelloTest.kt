import org.json.JSONArray
import org.junit.Assert.assertEquals
import org.junit.Test
import ro.mike.tuiasi.JsonParser

class JsonParserTest {

    @Test
    fun testParseJson() {
        // Given
        val inputJson = """
            {
                "name": "John",
                "age": 30,
                "married": true,
                "hobbies": [reading, running]
            }
        """.trimIndent()

        // When
        val parser = JsonParser()
        val outputMap = parser.parse(inputJson)

        // Then
        assertEquals("John", outputMap["name"])
        assertEquals(30, outputMap["age"])
        assertEquals(true, outputMap["married"])
        assertEquals(listOf("reading", "running"), (outputMap["hobbies"] as JSONArray).toList())
    }
}





