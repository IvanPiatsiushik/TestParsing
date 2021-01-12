import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        List<Areicle> areicleList = new ArrayList<>();

        Document document = Jsoup.connect("https://4pda.ru").get();
        Elements h1Elements = document.getElementsByAttributeValue("class","list-post-title");
        h1Elements.forEach(h1Element ->{
            Element aElement = h1Element.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();
            areicleList.add(new Areicle(url,title));

        });
        areicleList.forEach(System.out::println);

    }
}
class Areicle {
    private String url;
    private String name;

    public Areicle(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Areicle{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
