package scrapingdata.entity;

public abstract class BaseEntity {
    private String name;
    private String time;
    private String description;
    public BaseEntity(){

    }
    public BaseEntity(String name, String time, String description) {
        super();
        this.name = name;
        this.time = time;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name!=null) this.name = name;
        else this.name = "Không rõ";
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if(time!=null) this.time = time;
        else this.time = "Không rõ";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description!=null) this.description = description;
        else this.description = "";
    }
    public abstract String hienthi();

}