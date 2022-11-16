package api.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.main.dto.NewDTO;
import api.main.entity.NewEntity;
import api.main.service.NewService;
@CrossOrigin
@RestController /*= @Controller + @RespondBody */
@RequestMapping("/api/news")//url ko dc viet hoa
public class NewsController {
    //nhúng Service vào API, cần có @Service ở class NewService
    @Autowired
    private NewService newService;

    // @RequestMapping(value = "get", method = RequestMethod.GET) = @GetMapping(value = "get")
    //get
    @GetMapping("/{id}")
    public NewEntity getNew (@PathVariable Integer id){
        return newService.getOneNew(id);
    }
    @GetMapping()
    public NewEntity showAllClass(@RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "limit", required = true) Integer limit,
            @RequestParam(value = "search", required = false) String search) {
        return null;
    }
    //post
    @PostMapping()
    public NewEntity createNew (@RequestBody NewDTO model){
        return newService.save(model);
    }
    //put
    @PutMapping("/{id}")//:))
    public NewEntity updateNew (@PathVariable Integer id ,@RequestBody NewDTO model){
        return newService.updateNew(model,id);
    }
    @DeleteMapping("/{id}")
    public void deleteNew(@RequestBody Integer id){
      
    }
    ///.... nói chung là còn 1 cái delete nữa.
}
//http:/localhost:3030/api/new
//method

