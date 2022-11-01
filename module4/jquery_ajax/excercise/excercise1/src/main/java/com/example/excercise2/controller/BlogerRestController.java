package com.example.excercise2.controller;

import com.example.excercise2.dto.BlogerDTO;
import com.example.excercise2.model.Bloger;
import com.example.excercise2.model.Category;
import com.example.excercise2.service.IBlogerService;
import com.example.excercise2.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog/v1")
public class BlogerRestController {

    @Autowired
    private IBlogerService blogerService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Bloger>> getList() {
        List<Bloger> blogers = blogerService.find();
        if (blogers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogers, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Bloger>> search(@RequestParam String searchName) {
        List<Bloger> blogers = blogerService.search(searchName);
        if (blogers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBloger(@RequestBody BlogerDTO blogerDTO) {
        Bloger bloger = new Bloger();
        BeanUtils.copyProperties(blogerDTO, bloger);
        blogerService.save(bloger);
        return new ResponseEntity<>(bloger, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloger> updateBloger(@PathVariable int id, @RequestBody BlogerDTO blogerDTO) {
        Bloger currentBloger = blogerService.findById(id);
        if (currentBloger == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blogerDTO, currentBloger);
        blogerService.save(currentBloger);
        return new ResponseEntity<>(currentBloger, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBloger(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        if (bloger == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogerService.remove(bloger);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Bloger>> getListCategory(@PathVariable int categoryId) {
        List<Bloger> blogers = blogerService.findByCategory(categoryId);
        if (blogers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogers, HttpStatus.OK);
    }

    @GetMapping("/bloger/{id}")
    public ResponseEntity view(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        if (bloger == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bloger, HttpStatus.OK);
    }

    @GetMapping("/category/list")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categories = categoryService.getListCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
