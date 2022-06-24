package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/{id}")
    public String showHashtag(Model model, @PathVariable Long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "hashtag";
    }
}
