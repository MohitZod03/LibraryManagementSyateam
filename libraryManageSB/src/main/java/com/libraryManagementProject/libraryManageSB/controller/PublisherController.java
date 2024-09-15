package com.libraryManagementProject.libraryManageSB.controller;

import com.libraryManagementProject.libraryManageSB.entity.Category;
import com.libraryManagementProject.libraryManageSB.entity.Publisher;
import com.libraryManagementProject.libraryManageSB.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    // mapping for to get All Category
    @RequestMapping("/publishers")
    public String getAllPublishers(Model model){
        List<Publisher> publishers= publisherService.findAllPublisher();
        model.addAttribute("publishers",publishers);
        return "publishers";
    }

    // mapping for to get single Category
    @RequestMapping("/publisher/{id}")
    public String getSinglePublisher(@PathVariable Long id, Model model){
        Publisher publisher=publisherService.findById(id);
        model.addAttribute("publisher",publisher);
        return "list-publisher";
    }

// mapping for to get remove Category

    @RequestMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model){
        publisherService.deletedPublisher(id);
        model.addAttribute("publishers",publisherService.findAllPublisher());
        return "publishers";
    }

    // mapping for to get update category

    // binding result if any error in html page get into object.
    @RequestMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        // find book first.
        Publisher publisher=publisherService.findById(id);
        model.addAttribute("publisher",publisher);

        return "update-publisher";
    }
    // it is need to save the updated category list

    @PostMapping("/save-updatePublisher/{id}")
    public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model){
        if (result.hasErrors()){
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers",publisherService.findAllPublisher());
        return "redirect:/publishers";
    }



    // add Category
    @RequestMapping("/add-publisher")
    public String addPublisher( Publisher publisher, Model model){


        return "add-publisher";
    }
    @PostMapping("/save-publisher")
    public String addPublisher(Publisher publisher,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-publisher";
        }
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers",publisherService.findAllPublisher());
        return "redirect:/publishers";
    }



}
