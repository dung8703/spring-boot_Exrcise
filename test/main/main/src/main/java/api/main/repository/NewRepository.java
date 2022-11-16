package api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.main.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity,Integer>{
    NewEntity findOneById(Integer id);
}
