package scrapingdata;

import org.jsoup.nodes.Document;

public abstract class Base {
    protected String url;
    protected Document doc = null;

    public void setDoc(Document doc) {
        this.doc = doc;
    }
    public Base(String url){
        this.url = url;
    }
    public abstract boolean connect(String url);
    //public abstract void start() throws IOException;
}