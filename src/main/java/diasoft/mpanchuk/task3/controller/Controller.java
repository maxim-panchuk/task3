package diasoft.mpanchuk.task3.controller;

import diasoft.mpanchuk.task3.entity.Book;
import diasoft.mpanchuk.task3.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("books")
public class Controller {

    private int counter = 4;

    private Map<Integer, Book> bookStorage = new HashMap<>(){{
        put(1, new Book(1, "title1", "author1", 10));
        put(2, new Book(2, "title2", "author2", 20));
        put(3, new Book(3, "title3", "author3", 30));
        put(4, new Book(4, "title4", "author4", 40));
    }};



    @GetMapping
    public List<Book> getAll() {
        return new ArrayList<>(bookStorage.values());
    }

    @GetMapping("{title}")
    public Book getOne(@PathVariable String title) {
        for (Map.Entry<Integer, Book> entry : bookStorage.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                return entry.getValue();
            }
        }
        throw new NotFoundException();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        book.setId(counter++);
        bookStorage.put(counter, book);
        return book;
    }

    @PutMapping("{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book book) {
        Book bookDb = bookStorage.get(id);

        if (bookDb == null) {
            throw new NotFoundException();
        }
        bookDb.setTitle(book.getTitle());
        bookDb.setAuthor(book.getAuthor());
        bookDb.setPrice(book.getPrice());

        return bookDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        bookStorage.remove(id);
    }
}
