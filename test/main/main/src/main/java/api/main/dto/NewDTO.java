package api.main.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewDTO {
    private String title;
    private String content;
    private String shortDecription;
    private String categoryCode;
    private String thumbnail;
    
    public NewDTO() {
    }

    public NewDTO(String title, String content, String shortDecription, String categoryCode, String thumbnail) {
        this.title = title;
        this.content = content;
        this.shortDecription = shortDecription;
        this.categoryCode = categoryCode;
        this.thumbnail = thumbnail;
    }
    
}

