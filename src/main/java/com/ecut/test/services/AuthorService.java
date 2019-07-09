package com.ecut.test.services;

import com.ecut.test.generated.tables.pojos.Author;
import com.ecut.test.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amy
 * @date 2019-07-04 18:26
 * @description:
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public boolean insertAuthor(int id, String firstName, String lastName) {
        return authorRepository.insert(id, firstName, lastName);
    }

    public boolean delete(int id) {
        return authorRepository.deleteById(id);
    }

    public Author findAuthorById(int id) {
        return authorRepository.findById(id);
    }

    public List<Author> listAuthors() {
        return authorRepository.list();
    }
}
