package currency.controller;

import currency.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService convertService;
    @GetMapping("/")
    public String showForm(){
        return "/form";
    }
    @PostMapping
    public String convert(@RequestParam double usd, Model model){
        double vnd = convertService.convert(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "/form";
    }
}
