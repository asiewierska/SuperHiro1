package pl.agnieszka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.agnieszka.model.domain.Facebook;
import pl.agnieszka.model.domain.Post;
import pl.agnieszka.model.exception.NotFoundException;
import pl.agnieszka.service.FacebookService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class ProfileController {

    @Autowired
    FacebookService facebookService;

    @GetMapping({"/","home"})
    public String getHomePage(ModelMap model) {
        List<Facebook> facebookList = facebookService.findAll();
        model.addAttribute("profiles", facebookList);

        Set<String> sss = facebookService.findPostIdsByKeyword("great");
        model.addAttribute("messageSet", sss);

        return "home";
    }

    @GetMapping("all")
    public String getAllProfilesPage(ModelMap model) {
        List<Facebook> facebookList = facebookService.findAll();
        model.addAttribute("profiles", facebookList);
        return "all";
    }

    @GetMapping("find")
    public String findPage(ModelMap model) {
        model.addAttribute("profile", new Facebook());
        return "find";
    }

    @PostMapping("find")
    public String getGetByIdPage(ModelMap model, Facebook profile) {
        try {
            model.addAttribute("profile", facebookService.findById(profile.getId()));
        }catch (NotFoundException status){
            model.addAttribute("status", status.getText());
        }
        return "get_by_id";
    }

    @GetMapping("get_by_id")
    public String getByIdPage(ModelMap model) {
        return "get_by_id";
    }

}