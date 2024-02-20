package net.ugurkartal.springrestclientdemo.services;

import net.ugurkartal.springrestclientdemo.models.Character;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterServiceTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private static MockWebServer mockWebServer;

    @Autowired
    private CharacterService characterService;

    @BeforeAll
    static void setupMockWebServer() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void shutdownMockWebServer() throws IOException {
        mockWebServer.shutdown();
    }

    @DynamicPropertySource
    static void backendProps(DynamicPropertyRegistry registry) {
        registry.add("basic.url", () -> mockWebServer.url("/").toString());
    }

    @Test
    void getByIdCharacter_shouldReturnRickSanchez_whenCalledWithId1() throws Exception{
        mockWebServer.enqueue(new MockResponse()
                .setBody(
                        """
                                {
                                    "id": 1,
                                    "name": "Rick Sanchez",
                                    "status": "Alive",
                                    "species": "Human",
                                    "type": "",
                                    "gender": "Male",
                                    "origin": {
                                        "name": "Earth (C-137)",
                                        "url": "https://rickandmortyapi.com/api/location/1"
                                    },
                                    "location": {
                                        "name": "Citadel of Ricks",
                                        "url": "https://rickandmortyapi.com/api/location/3"
                                    },
                                    "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                                }
                                """
                )
                .addHeader("Content-Type", "application/json"));

        mvc.perform(MockMvcRequestBuilders.get("/api/characters/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "id": 1,
                            "name": "Rick Sanchez",
                            "status": "Alive",
                            "species": "Human"
                            }
                        """));
    }

    @Test
    void getAllCharacters_shouldReturnAllResponse() throws Exception {
        String responseBody = """
                {
                    "info": {
                        "count": 2,
                        "pages": 1,
                        "next": "",
                        "prev": ""
                    },
                    "results": [
                        {
                            "id": 1,
                            "name": "Rick Sanchez",
                            "status": "Alive",
                            "species": "Human"
                        },
                        {
                            "id": 2,
                            "name": "Morty Smith",
                            "status": "Alive",
                            "species": "Human"
                        }
                    ]
                }
                """;

        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader("Content-Type", "application/json"));

        List<Character> characters = characterService.getAllCharacters();

        assertNotNull(characters);
        assertEquals(2, characters.size());
        assertEquals("Rick Sanchez", characters.get(0).getName());
        assertEquals("Morty Smith", characters.get(1).getName());
    }


    @Test
    void getFilteredCharacters_shouldReturnCorrectCharacters_whenCalledWithValidStatus() throws Exception {
        String responseBody = """
            {
                "info": {
                    "count": 2,
                    "pages": 1,
                    "next": "",
                    "prev": ""
                },
                "results": [
                    {
                        "id": 1,
                        "name": "Rick Sanchez",
                        "status": "Alive",
                        "species": "Human"
                    },
                    {
                        "id": 2,
                        "name": "Morty Smith",
                        "status": "Alive",
                        "species": "Human"
                    }
                ]
            }
            """;

        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader("Content-Type", "application/json"));

        List<Character> characters = characterService.getFilteredCharacters("Alive");

        assertNotNull(characters);
        assertEquals(2, characters.size());
        assertEquals("Rick Sanchez", characters.get(0).getName());
        assertEquals("Morty Smith", characters.get(1).getName());
    }

    @Test
    void getSpeciesStatistics_shouldReturnCorrectCount_whenCalledWithValidSpecies() throws Exception {
        String responseBody = """
            {
                "info": {
                    "count": 2,
                    "pages": 1,
                    "next": "",
                    "prev": ""
                },
                "results": [
                    {
                        "id": 1,
                        "name": "Rick Sanchez",
                        "status": "Alive",
                        "species": "Human"
                    },
                    {
                        "id": 2,
                        "name": "Morty Smith",
                        "status": "Alive",
                        "species": "Human"
                    }
                ]
            }
            """;

        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader("Content-Type", "application/json"));

        int count = characterService.getSpeciesStatistics("Human");

        assertEquals(2, count);
    }

}