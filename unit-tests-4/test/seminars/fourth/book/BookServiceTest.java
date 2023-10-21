package seminars.fourth.book;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    public void testBookService(){
        //создадим мок объект
        BookRepository bookRepo = mock(BookRepository.class);

        //зададим возвращаемые данные методов мок объекта
        when(bookRepo.findAll())
                .thenReturn(List.of(
                        new Book("1","title1","author1"),
                        new Book("2","title2","author2")));
        when(bookRepo.findById("1")).thenReturn(new Book("1","title1","author1"));
        when(bookRepo.findById("2")).thenReturn(new Book("2","title2","author2"));
        when(bookRepo.findById("0")).thenReturn(null);
        BookService bookService  = new BookService(bookRepo);

        //проверим метод findBookById
        assertThat(bookService.findBookById("0")).isNull();//проверка на возврат null при отрицательном поиске
        verify(bookRepo).findById("0"); //проверка вызова метода findById в BookRepository
        assertThat(bookService.findBookById("1")).isInstanceOf(Book.class);
        assertThat(bookService.findBookById("2")).isInstanceOf(Book.class);

        //проверка метода findAllBooks
        assertThat(bookService.findAllBooks()).isInstanceOf(List.class);
        verify(bookRepo).findAll(); //проверка вызова метода findAll в BookRepository
        assertThat(bookService.findAllBooks().size()).isEqualTo(2);

        Book book = bookService.findBookById("1");
        assertThat(book.getId()).isEqualTo("1");
        assertThat(book.getTitle()).isEqualTo("title1");
        assertThat(book.getAuthor()).isEqualTo("author1");

        // Материал трудный, особенно с такими лекциями,
        // где просто галопом по верхам без кода и подробностей
        // раньше хоть методички были...
        // хорошо, что у вас на семинаре некоторые моменты рассмотрели
        // и пришло понимание зачем это все
    }

}