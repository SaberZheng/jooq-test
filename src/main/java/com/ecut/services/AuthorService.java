package com.ecut.services;

import com.ecut.generated.tables.Author;
import com.ecut.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amy
 * @date 2019-07-04 18:26
 * @description:
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorById(int id){
        return  authorRepository.findById(id);
    }

}