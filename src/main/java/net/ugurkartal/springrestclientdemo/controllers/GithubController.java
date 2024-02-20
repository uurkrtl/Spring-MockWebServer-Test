package net.ugurkartal.springrestclientdemo.controllers;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.springrestclientdemo.models.GithubUser;
import net.ugurkartal.springrestclientdemo.services.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/github")
@RequiredArgsConstructor
public class GithubController {
    private final GithubService githubService;



    @GetMapping("/user")
    public GithubUser getByLoginUser(@RequestParam String login){
        return this.githubService.getByLoginUser(login);
    }
}
