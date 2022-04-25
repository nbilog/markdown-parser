import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void MarkdownParse() throws IOException{
        Path filename = Path.of("test-file.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("https://something.com", links.get(0));
        assertEquals("some-thing.html", links.get(1));
    }
}