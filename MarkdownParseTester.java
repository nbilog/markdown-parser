import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParseTester {

    @Test
    public void MarkdownParse() throws IOException{
        Path filename = Path.of("snippet1.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("'google.com", links.get(0));
        assertEquals("google.com", links.get(1));
        assertEquals("ucsd.edu", links.get(2));
    }

    @Test
    public void MarkdownParseTest2() throws IOException{
        Path filename = Path.of("snippet2.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("a.com", links.get(0));
        assertEquals("a.com(())", links.get(1));
        assertEquals("example.com", links.get(2));
    }

    @Test
    public void MarkdownParseTest3() throws IOException{
        Path filename = Path.of("snippet3.md");
        String content = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("https://www.twitter.com", links.get(0));
        assertEquals("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", links.get(1));
        assertEquals("https://cse.ucsd.edu/", links.get(2));
    }
}