package com.ecut.repositories;

import com.ecut.generated.tables.pojos.Author;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.ecut.generated.tables.Author.AUTHOR;

/**
 * @author Amy
 * @date 2019-07-04 17:50
 * @description:
 */
@Repository
public class AuthorRepository {

    /**
     * 根据ID获取作者信息
     *
     * @param id id
     * @return 作者信息
     */
    public Author findById(int id) {
        Author author = new Author();
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/library";
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("数据库连接成功！");
             DSLContext dsl = DSL.using(conn, SQLDialect.MYSQL);
             author =dsl.select().from(AUTHOR).where(AUTHOR.ID.eq(id)).fetchOptionalInto(Author.class).orElse(null);
        }catch (Exception e){
            System.out.println("数据库连接异常 ！");
        }
        return author;
    }

}
