package net.ugurkartal.springrestclientdemo.services;

import net.ugurkartal.springrestclientdemo.models.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BookService {
    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://my-json-server.typicode.com/Flooooooooooorian/BookApi")
            .build();

    public Book[] getAllBooks() {
        Book[] books = restClient.get()
                .uri("/books")
                .retrieve()
                .body(Book[].class);
        return books;
    }

    public Book getByIdBook(String id){
        Book book = restClient.get()
                .uri("/books/" + id)
                .retrieve()
                .body(Book.class);
        return book;
    }
}