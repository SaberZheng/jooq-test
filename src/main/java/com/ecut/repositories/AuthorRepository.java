package com.ecut.repositories;

import com.ecut.generated.tables.pojos.Author;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.ecut.generated.tables.Author.AUTHOR;

/**
 * @author Amy
 * @date 2019-07-04 17:50
 * @description:
 */
@Repository
public class AuthorRepository {

    @Autowired
    private DSLContext dsl;

    /**
     * 根据ID获取作者信息
     *
     * @param id id
     * @return 作者信息
     */
    public Author findById(int id) {
        return dsl.select().from(AUTHOR).where(AUTHOR.ID.eq(id)).fetchOptionalInto(Author.class).orElse(null);
    }

}
