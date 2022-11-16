package api.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
// entity dùng để tạo bảng trong java không cần dùng đến câu lệnh SQL mà tự chuyển đổi qua
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
    @Column(name = "title")
    private String title;

    @Column(name = "code")
    private String code;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "content")
    private String content;
}
