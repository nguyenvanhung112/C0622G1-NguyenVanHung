package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/")
    public String showform() {
        return "/view";
    }

    @PostMapping
    public String dictionary(@RequestParam String eng, Model model) {
        String vietnamese = dictionaryService.getDictionary(eng);
        model.addAttribute("vietnamese", vietnamese);
        return "/view";
    }
}
