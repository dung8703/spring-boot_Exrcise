package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    CategoryEntity findOneByCode(String code);
}