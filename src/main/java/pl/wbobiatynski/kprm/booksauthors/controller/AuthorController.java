package pl.wbobiatynski.kprm.booksauthors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wbobiatynski.kprm.booksauthors.entity.Author;
import pl.wbobiatynski.kprm.booksauthors.exception.AuthorValidationException;
import pl.wbobiatynski.kprm.booksauthors.service.AuthorService;

import java.util.List;
@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/getAllAuthors")
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity<Author> delete (@PathVariable String id) {
        authorService.deleteAuthor(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createAuthor/{name}/{surname}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Author> createAuthor (@RequestBody String name, @RequestBody String surname) {
        authorService.createAuthor(name, surname);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editAuthor/{id}/{name}/{surname}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Author> editAuthor(@PathVariable Long id, @PathVariable String name, @PathVariable String surname) {
        authorService.editAuthor(id, name, surname);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<AuthorValidationException> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(new AuthorValidationException(exception.getMessage()));
    }
}

