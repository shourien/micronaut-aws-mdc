package example.micronaut;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BookController {

    @Post
    public BookSaved save(@Valid @Body Book book) {
        log.info("Test AWS MDC logging");
        BookSaved bookSaved = new BookSaved();
        bookSaved.setName(book.getName());
        bookSaved.setIsbn(UUID.randomUUID().toString());
        return bookSaved;
    }
}
