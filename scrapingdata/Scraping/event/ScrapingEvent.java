package scrapingdata.Scraping.event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import scrapingdata.manager.ScrapingManager;
import scrapingdata.entity.Event;

public class ScrapingEvent extends BaseScrapingEvent{
    public ScrapingEvent(String url) {
        super(url);
    }

 
    @Override
    public boolean connect(String url) {
        try {
            this.doc = Jsoup.connect(url).get();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void getData() throws IOException {
        File theFile = new File("src\\main\\java\\json\\event.json");
        this.connect(url);
        int count = 0;
        Elements itemsElements = doc.select("div[class=mw-parser-output]");
        for (Element element : itemsElements) {
            Elements e1 = element.getElementsByTag("p");
            for (Element element2 : e1) {
                if(element2.nextElementSibling() != null) {
                    Event event = new Event();
                    if(element2.nextElementSibling().tagName() == "dl") {
                        event.setName(element2.text()+ " " + element2.nextElementSibling().text());
                        event.setTime(element2.getElementsByTag("b").text() + " " + element2.nextElementSibling().getElementsByTag("b").text());
                        event.setDynastyname("abcd");
                        String hrefString = element2.nextElementSibling().getElementsByTag("a").attr("href");
                        Elements eleDocument = Jsoup.connect("https://vi.wikipedia.org/"+hrefString).get().select("div[class=mw-parser-output]");
                        event.setDescription(eleDocument.select("p").get(0).text());
                        ScrapingManager.setCountUrlBrowsed();
                    }
                    else {
                        event.setName(element2.text());
                        event.setTime(element2.getElementsByTag("b").text());
                        event.setDynastyname("abcd");
                        if(!element2.getElementsByTag("a").attr("class").equals("new")) {
                            String hrefString = element2.getElementsByTag("a").attr("href");
                            Elements eleDocument = Jsoup.connect("https://vi.wikipedia.org/"+hrefString).get().select("div[class=mw-parser-output]");
                            event.setDescription(eleDocument.select("p").get(0).text());
                            ScrapingManager.setCountUrlBrowsed();
                        }
                    }

                    count++;
                    this.eventList.add(event);
                }
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(theFile);
            Gson pretty_gs = new GsonBuilder().setPrettyPrinting().create();
            pretty_gs.toJson(this.eventList, fileWriter);
            fileWriter.close();

            ScrapingManager.setEntityCrawled("Sự kiên - Wiki", count);

        }catch (IOException e){
            System.err.println("Error in writing a file.");
        }
    }

    @Override
    public void start() throws IOException {
        String url = "https://vi.wikipedia.org/wiki/Ni%C3%AAn_bi%E1%BB%83u_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";
        BaseScrapingEvent eventCrawler = new ScrapingEvent(url);
        eventCrawler.getData();
        ScrapingManager.setBaseWebList("Event", url);

    }

    public static void main(String[] args) throws IOException {
        String url = "https://vi.wikipedia.org/wiki/Ni%C3%AAn_bi%E1%BB%83u_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";
        BaseScrapingEvent eventCrawler = new ScrapingEvent(url);
        eventCrawler.start();
    }
}