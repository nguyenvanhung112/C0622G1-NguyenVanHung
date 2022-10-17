package email.controller;

import email.model.Email;
import email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    IEmailService emailService;


    @GetMapping("/showForm/{id}")
    public String setting(@PathVariable int id, Model model) {
        List<String> languagesList = emailService.getListLanguage();
        List<Integer> size = emailService.getListSize();
        Email email = emailService.getEmail(id);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("size", size);
        model.addAttribute("email", email);
        return "/setting";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Email email) {
        emailService.edit(email);
        return "redirect:/email/list";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Email> emailList = emailService.getList();
        model.addAttribute("emailList", emailList);
        return "/show";
    }
}
