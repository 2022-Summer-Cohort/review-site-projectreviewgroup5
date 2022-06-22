package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.HashtagRepository;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {

    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/")
    public String showAllHashTags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "allHashtags";
    }
}
