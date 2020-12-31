package com.tts.PositiveVibes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.PositiveVibes.model.Tag;
import com.tts.PositiveVibes.model.User;
import com.tts.PositiveVibes.model.Vibe;
import com.tts.PositiveVibes.service.UserService;
import com.tts.PositiveVibes.service.VibeService;


@Controller
public class VibeController {
	   @Autowired
	    private UserService userService;

	    @Autowired
	    private VibeService vibeService;

	    @GetMapping(value = { "/tweets", "/" })
	    public String getFeed(Model model) {
	        List<Vibe> vibes =  vibeService.findAll();
	        model.addAttribute("vibeList", vibes);
	        return "feed";
	    }

	    @GetMapping(value = "/vibes/new")
	    public String creatingMethodName(Model model) {
	        model.addAttribute("vibe", new Vibe());
	        return "newVibe";
	    }

	    @PostMapping(value = "/vibes")
	    public String submitVibeForm(@Valid Vibe vibe, BindingResult bindingResult, Model model) {
	        User user = userService.getLoggedInUser();
	        if (!bindingResult.hasErrors()) {
	            vibe.setUser(user);
	            vibeService.save(vibe);
	            model.addAttribute("successMessage", "Vibe successfully created!");
	            model.addAttribute("tweet", new Vibe());
	        }
	        return "newVibe";
	    }

	    @GetMapping(value = "/vibes/{tag}")
	    public String getVibesByTag(@PathVariable(value = "tag") String tag, Model model) {
	        List<Vibe> vibes = vibeService.findAllWithTag(tag);
	        model.addAttribute("vibeList", vibes);
	        model.addAttribute("tag", tag);
	        return "taggedVibes";
	    }
	}