package api.main.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.main.dto.NewDTO;
import api.main.entity.CategoryEntity;
import api.main.entity.NewEntity;
import api.main.exception.InternalServerException;
import api.main.exception.NotFoundException;
import api.main.repository.CategoryRepository;

@Component
public class NewConverter {
    @Autowired
    private CategoryRepository categoryRepository;
    public NewEntity toEntity(NewDTO dto){
        try {
                CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
                if(categoryEntity == null) throw new NotFoundException("Not found category code : " + dto.getCategoryCode());
                NewEntity entity = new NewEntity(
                dto.getTitle(), 
                dto.getContent(), 
                dto.getShortDecription(), 
                dto.getThumbnail(),
                categoryEntity.getId()
            );
            return entity;
        } catch (Exception e) {
            throw new InternalServerException("to entity"+e.getMessage());
        }
        
    }
    public NewDTO todDTO(NewEntity entity){
        try {
                CategoryEntity categoryEntity = categoryRepository.findOneById(entity.getCategoryId());
                if(categoryEntity == null) throw new NotFoundException("Not found category code id: " + entity.getCategoryId());
                NewDTO dto = new NewDTO(
                entity.getTitle(), 
                entity.getContent(), 
                entity.getShortDecription(), 
                categoryEntity.getCode(), 
                entity.getThumbnail()
            );
            return dto;
        } catch (Exception e) {
            throw new InternalServerException("to dto"+e.getMessage());
        }
        
    }
}
