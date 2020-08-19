package com.arobs.sbw;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.arobs.sbw.controllers.BookController;
import com.arobs.sbw.model.Book;
import com.arobs.sbw.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author vasile.mihali
 * @since 8/19/2020
 */

@WebMvcTest
public class BookControllerTest extends BaseTest {

    @MockBean
    BookService bookService;

    @Autowired
    ObjectMapper objectMapper;

    MockMvc mockMvc;
    BookController bookController;

    @Before
    public void setUp() {
        bookController = new BookController(bookService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void findbyName() throws Exception {
        //given
        Book book = new Book();
        final String authorFromTest = "Author from test";
        book.setAuthor(authorFromTest);
        book.setTitle("Title from test");
        when(bookService.findBookForTitle(anyString())).thenReturn(Optional.of(book));

        //when
        mockMvc.perform(
            MockMvcRequestBuilders.get("/book")
                .param("title", "input param")
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(objectMapper.writeValueAsString(book)));
        //then

    }

}
