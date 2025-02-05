package com.security.controller;

import com.security.dto.PageDto;
import com.security.entity.Page;
import com.security.repository.PageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/admin")
/*public class AdminController {

    private final PageRepository pageRepository;
    private final ModelMapper modelMapper;

    public AdminController(PageRepository pageRepository, ModelMapper modelMapper) {
        this.pageRepository = pageRepository;
        this.modelMapper = modelMapper;
    }


    @RequestMapping(value = "/add-page",method = RequestMethod.POST)
    public String addPage(Model model){
        model.addAttribute("pageFormDto",new PageDto());
        return "addPage";
    }

    @RequestMapping(value = "/add-page",method = RequestMethod.GET)
    public String renderSucessMessage(Model model){
        model.addAttribute("pageFormDto",new PageDto());
        return "viewPage";
    }
    @RequestMapping(value = "/add-page-action",method = RequestMethod.POST)
    public String processAddPage(
            @ModelAttribute PageDto pageFormDto,
            BindingResult bindingResult,
            Model model
            ){

        Page page = modelMapper.map(pageFormDto,Page.class);
        pageRepository.save(page);
        return "redirect:/admin/addPage?message=Page added successfully";
    }
}*/
