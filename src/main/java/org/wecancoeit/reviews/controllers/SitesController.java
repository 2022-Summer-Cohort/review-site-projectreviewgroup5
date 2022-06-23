package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.SitesRepository;

@Controller
@RequestMapping("/sites")
public class SitesController {

    private SitesRepository sitesRepo;

    public SitesController(SitesRepository sitesRepo) {
        this.sitesRepo = sitesRepo;
    }

    @RequestMapping("/")
    public String showAllPaidSites(Model model) {
        model.addAttribute("sites", sitesRepo.findAll());
        return "allSites";
    }

    @RequestMapping("/{id}")
    public String showSite(Model model, @PathVariable Long id) {
        model.addAttribute("site", sitesRepo.findById(id).get());
        return "site";
    }


}
