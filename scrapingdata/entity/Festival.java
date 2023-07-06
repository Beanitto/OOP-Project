package scrapingdata.entity;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Festival extends BaseEntity {
    private String place;
    private String firstTime;
    private String character;

    public Festival() {

    }

    

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
    @Override
    public String hienthi() {
		return "Tên: " + this.getName() + "\n" + "Thời gian: " + this.getTime() + "\n" + "Địa điểm: " + this.getPlace() + "\n" + "Lần đầu tổ chức: " + this.getFirstTime() + "\n" + "Nhân vật: " + this.getCharacter()
			+ "\n" + "Chi Tiết: " + this.getDescription();
	}
}
