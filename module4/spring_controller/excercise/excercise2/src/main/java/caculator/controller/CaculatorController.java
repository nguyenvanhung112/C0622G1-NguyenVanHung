package caculator.controller;

import caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    ICaculatorService caculatorService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @RequestMapping("/result")
    public String result(@RequestParam double a, double b, String submit, Model model) {
        double result;
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        switch (submit) {
            case "summation":
                result = caculatorService.summation(a, b);
                model.addAttribute("result", result);
                break;
            case "subtraction":
                result = caculatorService.subtraction(a, b);
                model.addAttribute("result", result);
                break;
            case "multiplication":
                result = caculatorService.multiplication(a, b);
                model.addAttribute("result", result);
                break;
            case "division":
                if (b == 0) {
                    model.addAttribute("result", "Sai ! b phải khác 0");
                    break;
                } else {
                    result = caculatorService.division(a, b);
                    model.addAttribute("result", result);
                    break;
                }
        }
        return "/home";
    }

}
