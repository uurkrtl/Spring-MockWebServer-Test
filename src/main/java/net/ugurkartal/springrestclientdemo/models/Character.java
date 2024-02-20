package net.ugurkartal.springrestclientdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
}