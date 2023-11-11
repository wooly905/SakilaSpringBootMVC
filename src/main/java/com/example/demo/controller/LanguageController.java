package com.example.demo.controller;

import com.example.demo.entity.Language;
import com.example.demo.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    // http://localhost:8080/language-list
    @GetMapping("/language-list")
    public String getLanguages(Model model) {
        List<Language> languages = languageRepository.findAll();
        model.addAttribute("languages", languages);
        return "/sakila/language-list.html";
    }

    @GetMapping("addlanguage")
    public String showAddLanguageForm(Model model) {
        model.addAttribute("language", new Language());
        return "/sakila/addLanguage.html";
    }

    @PostMapping("savelanguage")
    public String addLanguage(@ModelAttribute Language language) {
        languageRepository.save(language);
        return "redirect:/language-list";
    }

    @GetMapping("/editlanguage/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        Optional<Language> lang = languageRepository.findById(id);

        if (lang.isPresent()) {
            model.addAttribute("language", lang.get());
            return "/sakila/editlanguage";
        }

        return "/sakila/warning";
    }

    @GetMapping("deletelanguage/{id}")
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageRepository.deleteById(id);
        return "redirect:/language-list";
    }
}
