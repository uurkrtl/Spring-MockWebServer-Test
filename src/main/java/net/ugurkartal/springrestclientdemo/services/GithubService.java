package net.ugurkartal.springrestclientdemo.services;

import net.ugurkartal.springrestclientdemo.models.GithubUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GithubService {
    private RestClient restClient = RestClient.builder()
            .baseUrl("https://api.github.com")
            .build();

    public GithubUser getByLoginUser(String login) {
        GithubUser user = restClient.get()
                .uri("/users/" + login)
                .retrieve()
                .body(GithubUser.class);
        return user;
    }


}
