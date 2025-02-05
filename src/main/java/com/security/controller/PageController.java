package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {

    private final com.security.repository.PageRepository pageRepository;

    public PageController(com.security.repository.PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }


    @GetMapping("/login")
    public String indexPage()
    {
        return "home";
    }

    @GetMapping("/")
    public String homePage()
    {
        return "home";
    }

    @PostMapping("/do-login")
    public String doLogin(){ return "redirect:/viewPage";}


    // Show Add Page Form
    @GetMapping("/addPage")
    public String showAddPageForm(Model model) {
        model.addAttribute("pageDto", new com.security.dto.PageDto());
        return "addPage";
    }

    // Handle Form Submission
    @PostMapping("/addPage")
    public String submitPageForm( @ModelAttribute("pageDto") com.security.dto.PageDto pageDto,
                                 BindingResult result, Model model) {
        com.security.entity.Page page = new com.security.entity.Page(pageDto.getPageName());
        pageRepository.save(page);
        return "redirect:/viewPage";  // Redirect to view all pages
    }

    // View All Pages
    @GetMapping("/viewPage")
    public String viewPages(Model model) {
        List<com.security.entity.Page> pages = pageRepository.getAllByName();
        model.addAttribute("pages", pages);
        return "viewPage";
    }

    // 4️⃣ Help Page
    @GetMapping("/help")
    public String helpPage() {
        return "help";
    }

    // 5️⃣ Logout (Redirect to Home)
    @GetMapping("/logout")
    public String logout() {
        return "home";
    }
}
