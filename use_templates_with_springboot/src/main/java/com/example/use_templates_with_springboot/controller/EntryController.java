package com.example.use_templates_with_springboot.controller;

import com.example.use_templates_with_springboot.domain.Entry;
import com.example.use_templates_with_springboot.reposity.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-29上午12:23
 **/
@Controller
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @RequestMapping("/")
    public String home(Model model) {
        List<Entry> allEntry = entryRepository.findAll();
        for (Entry entry : allEntry) {
            System.out.println(entry.getId());

        }
        /*model.addAttribute("title", "hello world!!!");*/
        model.addAttribute("entries", allEntry);
        return "home";
    }


    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public String newEntry(Model model) {
        model.addAttribute("pageTitle", "New Entry");
        model.addAttribute("givenAction", "/entry");
        model.addAttribute("givenTitle", "");
        model.addAttribute("givenContext", "");
        return "entry";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String addEntry(@RequestParam String title,@RequestParam String context) {
        Entry newEntry = new Entry(title, context);
        entryRepository.save(newEntry);
        return "redirect:/";
    }

    @RequestMapping(value = "/entry/{id}",method = RequestMethod.GET)
    public String editEntry(@PathVariable(value = "id") Long entryId, Model model) {
        Optional<Entry> entry = entryRepository.findById(entryId);
        model.addAttribute("pageTitle", "EditEntry");
        model.addAttribute("givenAction", "/entry/"+entryId);
        model.addAttribute("givenTitle", entry.get().getTitle());
        model.addAttribute("givenContext", entry.get().getContext());
        return "entry";
    }

    @RequestMapping(value = "/entry/{id}", method = RequestMethod.POST)
    public String updateEntry(@PathVariable(value = "id")Long entryId,
                              @RequestParam String title,
                              @RequestParam String context) {
        Optional<Entry> entry = entryRepository.findById(entryId);
        entry.get().setTitle(title);
        entry.get().setContext(context);
        entryRepository.save(entry.get());
        return "redirect:/";
    }


    @RequestMapping(value = "/entry/delete/{id}", method = RequestMethod.GET)
    public String deleteEntry(@PathVariable(value = "id") Long entryId) {
        entryRepository.deleteById(entryId);
        return "redirect:/";
    }

}
