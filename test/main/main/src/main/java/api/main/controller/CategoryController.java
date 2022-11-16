package api.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.main.entity.CategoryEntity;
import api.main.service.NewService;
@CrossOrigin
@RestController /*= @Controller + @RespondBody */
@RequestMapping("/api/category")//url ko dc viet hoa
public class CategoryController {
    @Autowired
    private NewService newService;

    @GetMapping("/{id}")
    public CategoryEntity  getategory (@PathVariable Integer id){
        return newService.getOneCategory(id);
    }

    @GetMapping()
    public CategoryEntity showAllClass(@RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "limit", required = true) Integer limit,
            @RequestParam(value = "search", required = false) String search) {
        return null;
    }
    //post làm tạo mới category luôn đi e
    @PostMapping()
    public String createNew (@RequestBody String model){
        return null;
    }
    //put
    @PutMapping("/{id}")
    public String updateNew (@PathVariable Integer newId ,@RequestBody String model){
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteNew(@RequestBody Integer id){
      
    }
}
