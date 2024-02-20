package net.ugurkartal.springrestclientdemo.controllers;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.springrestclientdemo.models.Character;
import net.ugurkartal.springrestclientdemo.services.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/")
    public List<Character> getAllCharacters(){
        return this.characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getByIdCharacter(@PathVariable int id){
        return this.characterService.getByIdCharacter(id);
    }

    @GetMapping
    public List<Character> getFilteredCharacters(@RequestParam String status){
        return this.characterService.getFilteredCharacters(status);
    }

    @GetMapping("/species-statistic")
    public int getSpeciesStatistics(@RequestParam String species){
        return this.characterService.getSpeciesStatistics(species);
    }

}
