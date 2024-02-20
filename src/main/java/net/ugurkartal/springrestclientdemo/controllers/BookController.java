package net.ugurkartal.springrestclientdemo.controllers;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.springrestclientdemo.models.Book;
import net.ugurkartal.springrestclientdemo.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public Book[] getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getByIdBook(@PathVariable String id){
        return this.bookService.getByIdBook(id);
    }
}
