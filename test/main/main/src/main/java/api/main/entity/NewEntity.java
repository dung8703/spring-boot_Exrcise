package api.main.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "news")
public class NewEntity extends BaseEntity{

    @Column
    private String title;
    @Column
    private String thumbnail;
    @Column(name = "short_decription")
    private String shortDecription;
    @Column
    private String content;
    @Column(name = "category_id")
    private Integer categoryId;
    public NewEntity() {
    }
    public NewEntity(String title, String thumbnail, String shortDecription, String content, Integer categoryId) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.shortDecription = shortDecription;
        this.content = content;
        this.categoryId = categoryId;
    }
    
    
}
