package com.arobs.sbw.services;

import com.arobs.sbw.model.Book;
import com.arobs.sbw.repositories.BookRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vasile.mihali
 * @since 8/12/2020
 */

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookForTitle(String titleSearch) {
        return bookRepository.findByTitleLike(titleSearch);
    }
}
