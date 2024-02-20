package net.ugurkartal.springrestclientdemo.services;

import net.ugurkartal.springrestclientdemo.models.Character;
import net.ugurkartal.springrestclientdemo.models.CharacterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CharacterService {

    private RestClient restClient;
    public CharacterService(@Value("${basic.url}") String basicUrl) {
        restClient = RestClient.builder()
                .baseUrl(basicUrl)
                .build();
    }


    public List<Character> getAllCharacters() {
        CharacterResponse characterResponse = restClient.get()
                .uri("/character")
                .retrieve()
                .body(CharacterResponse.class);
        return characterResponse.getResults();
    }

    public Character getByIdCharacter(int id) {
        Character character = restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(Character.class);
        return character;
    }

    public List<Character> getFilteredCharacters(String status) {
        CharacterResponse characterResponse = restClient.get()
                .uri("/character/?status=" + status)
                .retrieve()
                .body(CharacterResponse.class);
        return characterResponse.getResults();
    }

    public int getSpeciesStatistics(String species) {
        CharacterResponse response = restClient.get()
                .uri("/character/?status=alive&species="+species)
                .retrieve()
                .body(CharacterResponse.class);
        return response.getInfo().getCount();
    }
}
