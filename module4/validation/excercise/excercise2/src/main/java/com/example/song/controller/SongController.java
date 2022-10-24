package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/song")
public class SongController {


    @Autowired
    ISongService service;

    @GetMapping("")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("song/list");
        modelAndView.addObject("songs", service.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("song/create");
        modelAndView.addObject("songDTO", new SongDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("song/create");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("song/create");
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            service.save(song);
            modelAndView.addObject("songDTO", new SongDTO());
            modelAndView.addObject("message", "Song created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        Song song = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("song/edit");
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        modelAndView.addObject("songDTO", songDTO);
        return modelAndView;
    }


    @PostMapping("/edit")
    public ModelAndView editForm(@ModelAttribute @Validated SongDTO songDTO, BindingResult bindingResult) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("song/edit");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            service.save(song);
            ModelAndView modelAndView = new ModelAndView("song/edit");
            modelAndView.addObject("songDto", songDTO);
            modelAndView.addObject("message", "Song edited successfully");
            return modelAndView;
        }
    }
}
