package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Sites;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.SitesRepository;

import java.util.Optional;

@Controller
@RequestMapping("/sites")
public class SitesController {

    private SitesRepository sitesRepo;
    private HashtagRepository hashtagRepo;

    public SitesController(SitesRepository sitesRepo, HashtagRepository hashtagRepo) {
        this.sitesRepo = sitesRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/")
    public String showAllSites(Model model) {
        model.addAttribute("sites", sitesRepo.findAll());
        return "allSites";
    }

    @RequestMapping("/{id}")
    public String showSite(Model model, @PathVariable Long id) {
        model.addAttribute("site", sitesRepo.findById(id).get());
        return "site";
    }

    @PostMapping("/{id}/addHashtag")
    public String addHashtagToSite(@PathVariable Long id, @RequestParam String hashtag) {
        Sites site = sitesRepo.findById(id).get();
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByNameIgnoreCase(hashtag);
        if(hashtagOptional.isPresent()) {
            if(!site.getHashtags().contains(hashtagOptional.get())) {
                site.addHashtag(hashtagOptional.get());
            }
        } else {
            Hashtag hashtag15 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag15);
            site.addHashtag(hashtag15);
        }
        sitesRepo.save(site);
        return "redirect:/sites/"+id;
    }


}
