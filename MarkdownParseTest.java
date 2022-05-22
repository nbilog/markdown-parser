import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class MarkdownParseTest {

    @Test
    public void MarkdownParse() throws IOException{
        Path filename = Path.of("C:/Users/ThugBlazed/Documents/GitHub/markdown-parser/snippet1.md");
        String content = Files.readString(filename);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expect = List.of("'google.com", "google.com", "ucsd.edu");
        assertEquals(expect, links);
    }

    @Test
    public void MarkdownParseTest2() throws IOException{
        Path filename = Path.of("C:/Users/ThugBlazed/Documents/GitHub/markdown-parser/snippet2.md");
        String content = Files.readString(filename);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, links);
    }

    @Test
    public void MarkdownParseTest3() throws IOException{
        Path filename = Path.of("C:/Users/ThugBlazed/Documents/GitHub/markdown-parser/snippet3.md");
        String content = Files.readString(filename);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expect = List.of("https://www.twitter.com", "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/");
        assertEquals(expect, links);
    }
}