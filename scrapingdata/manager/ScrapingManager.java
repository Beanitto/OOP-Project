package scrapingdata.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrapingManager {
    private static Map<String, Integer> entityDisplay  = new HashMap<String, Integer>();

    private static Map<String, Integer> entityCrawled = new HashMap<String, Integer>();;

    private static Map<String, String> BaseWebList = new HashMap<String, String>();

    private static int countUrlBrowsed;


    public static void setEntityDisplay(String key, Integer value) {
    	ScrapingManager.entityDisplay.put(key, value);
    }

    public static void setEntityCrawled(String key, Integer value) {
    	ScrapingManager.entityCrawled.put(key, value);
    }

    public static Map<String, Integer> getEntityCrawled() {
        return entityCrawled;
    }

    public static void setBaseWebList(String entity, String url) {
    	ScrapingManager.BaseWebList.put(entity, url) ;
    }

    public static Map<String, String> getBaseWebList() {
        return BaseWebList;
    }

    public static void setCountUrlBrowsed() {
    	ScrapingManager.countUrlBrowsed++;
    }

    public static int getCountUrlBrowsed() {
        return countUrlBrowsed;
    }

    public static int totalUrlBrowsed() {
        return countUrlBrowsed + BaseWebList.size();
    }

    public static Map<String, Integer> getEntityDisplay() {
        return entityDisplay;
    }
}