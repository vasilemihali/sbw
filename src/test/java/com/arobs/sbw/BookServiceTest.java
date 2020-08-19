package com.arobs.sbw;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.arobs.sbw.model.Book;
import com.arobs.sbw.repositories.BookRepository;
import com.arobs.sbw.services.BookService;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.StringUtils;

/**
 * @author vasile.mihali
 * @since 8/19/2020
 */
public class BookServiceTest extends BaseTest {

    @MockBean
    BookRepository bookRepositoryfdfsd;

    @Autowired
    BookService bookService;

    @Test
    public void findByNameTest() {
        //given
        Book book = new Book();
        final String authorFromTest = "Author from test";
        book.setAuthor(authorFromTest);
        book.setTitle("Title from test");
        when(bookRepositoryfdfsd.findByTitleLike(anyString())).thenReturn(Optional.of(book));

        //when
        final Optional<Book> bookFromService = bookService.findBookForTitle("search input");

        //then
        Assert.assertTrue(bookFromService.isPresent());
        final Book bookFromOptional = bookFromService.get();
        final String author = bookFromOptional.getAuthor();
        Assert.assertFalse(StringUtils.isEmpty(author));
        Assert.assertEquals("Author name should be enhanced by the service", authorFromTest + BookService.ENHANCED_BY_SERVICE, author);
    }

}
