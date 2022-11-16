package api.main.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass   
public abstract class BaseEntity {
    @Id//khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
