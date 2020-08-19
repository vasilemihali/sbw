package com.arobs.sbw.controllers;

import com.arobs.sbw.model.Book;
import com.arobs.sbw.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vasile.mihali
 * @since 8/12/2020
 */

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookByTitleLike(@RequestParam("title") String title) {
        return ResponseEntity.of(bookService.findBookForTitle(title));
    }
}
