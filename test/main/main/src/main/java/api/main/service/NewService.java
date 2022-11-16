package api.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.main.converter.NewConverter;
import api.main.dto.NewDTO;
import api.main.entity.CategoryEntity;
import api.main.entity.NewEntity;
import api.main.exception.*;
import api.main.repository.CategoryRepository;
import api.main.repository.NewRepository;

@Service
public class NewService{
    //nhúng NewRepository vào Service, cần có Annotation @Repository ở interface NewRepository nhưng JpaRepository đã có rồi nên không cần thêm
    @Autowired
    private NewRepository newRepository;

    //nhúng CategoryRepository vào Service, cần có Annotation @Repository ở interface CategoryRepository nhưng JpaRepository đã có rồi nên không cần thêm
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    // CHHƯA HIỂU, CẦN XEM LẠI (PHẦN 2, 23P30S)
    public NewEntity save(NewDTO newDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        if(categoryEntity == null) throw new NotFoundException("Not Found code name: " + newDTO.getCategoryCode());
        NewEntity newEntity = new NewEntity();
        newEntity = newConverter.toEntity(newDTO);
        try {
            newEntity = newRepository.save(newEntity);
            return newEntity;
        } catch (Exception e) {
            throw new InternalServerException("eror: "+e.getMessage());
        }
    }
    public NewEntity updateNew(NewDTO dto,Integer id)
    {
        NewEntity oldEntity = new NewEntity();
        oldEntity = newRepository.findOneById(id);
        if(oldEntity == null) throw new NotFoundException("Not Found news id: " + id.toString());

        NewEntity newEntity = newConverter.toEntity(dto);
        try {
            newEntity.setId(oldEntity.getId());
            newEntity = newRepository.save(newEntity);
            return newEntity;
        } catch (Exception e) {
            throw new InternalServerException("eror: "+e.getMessage());
        }
    }
    public CategoryEntity getOneCategory(Integer id)
    {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity = categoryRepository.findOneById(id);
        return categoryEntity;
    }
    
    public NewEntity getOneNew(Integer id){
        NewEntity newEntity = new NewEntity();
        newEntity = newRepository.findOneById(id);
        return newEntity;

    }
    public NewRepository getNewRepository() {
        return newRepository;
    }

    public void setNewRepository(NewRepository newRepository) {
        this.newRepository = newRepository;
    }
}
