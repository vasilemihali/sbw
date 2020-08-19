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

    public static final String ENHANCED_BY_SERVICE = " Enhanced by Service";
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookForTitle(String titleSearch) {

        final Optional<Book> byTitleLike = bookRepository.findByTitleLike(titleSearch);

        if (byTitleLike.isPresent()) {
            final Book book = byTitleLike.get();
            book.setAuthor(book.getAuthor() + ENHANCED_BY_SERVICE);
        }

        return byTitleLike;
    }
}
