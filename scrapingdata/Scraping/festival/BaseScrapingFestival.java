package scrapingdata.Scraping.festival;

import scrapingdata.Base;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public abstract class BaseScrapingFestival extends Base{
	public BaseScrapingFestival(String url) {
		super(url);
	}

		
	@Override
	public boolean connect(String url) {
		Document document = null;
		try {
			document = Jsoup
					.connect(url)
					.userAgent("Jsoup client")
					.timeout(20000).get();
			setDoc(document);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public abstract void getData() ;

}