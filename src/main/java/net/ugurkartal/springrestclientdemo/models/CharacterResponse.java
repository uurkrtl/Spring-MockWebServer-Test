package net.ugurkartal.springrestclientdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {
    CharacterInfo info;
    List<Character> results;
}
