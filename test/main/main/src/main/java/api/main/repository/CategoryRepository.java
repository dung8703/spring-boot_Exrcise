package api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.main.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer>{
    CategoryEntity findOneByCode(String code);
    CategoryEntity findOneById(Integer id);
}
