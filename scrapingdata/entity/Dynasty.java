
package scrapingdata.entity;

import java.util.ArrayList;


public class Dynasty extends BaseEntity {

    private String kingdom;
    private String capital;
    private ArrayList<String> king;

    public String getKingdom() {
        return kingdom;
    }
    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public ArrayList<String> getKing() {
        return king;
    }
    public void setKing(ArrayList<String> king) {
        this.king = king;
    }



    @Override
    public String hienthi() {
        return "Tên: " + this.getName() + "\n" + "Thời gian: " + this.getTime() + "\n" + "Tên nước: " + this.getKingdom() + "\n" + "Thủ đô: " + this.getCapital() + "\n" + "các đời vua: " + /*this.getKing().toString()*/
                 "\n" +  "Chi tiết: " + this.getDescription();
    }
}