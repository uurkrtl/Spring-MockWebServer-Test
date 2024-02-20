## Setup: Github Project

As a team, create your shared project where you will build an API that outputs Rick and Morty characters in the following steps.

In this first step, please create a Spring Boot project (Web + Lombok) and share it via GitHub. Do not add any logic yet - we will do that in the next steps.

What is the URL of your shared GitHub repository?
`inputfield`

## Coding: Passing Data

Now use the data from this Rick&Morty API: https://rickandmortyapi.com

Write an endpoint that returns all Rick&Morty characters (but with reduced character details).

When you enter GET http://localhost:8080/api/characters/ in Postman, all characters should be outputted in this example format:
```
[
  {"id": 1, "name": "Rick Sanchez", "species": "Human"},
  {"id": 2, "name": "Morty Smith", "species": "Human"},
  ... weitere
]
```

## Coding: Searching by ID

Write an endpoint that returns a Rick&Morty character. When you enter GET http://localhost:8080/api/characters/2 in Postman, the character with ID 2 should be returned.
```
``{"id": 2, "name": "Rick Sanchez", "species": "Human"}
```

## Coding: Filtering

Write an endpoint that returns a filtered list of Rick&Morty characters. It should be filtered by status.

When you enter GET http://localhost:8080/api/characters?status=alive in Postman, a list of living characters should be returned.

## Coding: Statistics

Write an endpoint for species statistics.

When you enter GET http://localhost:8080/api/species-statistic?species=Human in Postman, the number of living "Human" characters should be outputted as a number (not JSON). The same should work for all other species.

By the way, how many living humans are there?
`inputfield`

## Bonus: Book API

As a bonus, another task to integrate an external API.

Integrate the Book API from https://my-json-server.typicode.com/Flooooooooooorian/BookApi/books into your BookLibrary project.

For example, `GET https://my-json-server.typicode.com/Flooooooooooorian/BookApi/books/978-3-8362-8745-6`.

## Bonus: Github API

Provide an `/api/github/<username>` endpoint that retrieves the profile of the respective user using the Github API.

Be creative and add additional endpoints to your server that retrieve more information from the Github API.