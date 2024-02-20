package net.ugurkartal.springrestclientdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubUser {
    private String login;
    private Instant created_at;
    private Instant updated_at;
    private int public_repos;
    private int followers;
    private int following;
}