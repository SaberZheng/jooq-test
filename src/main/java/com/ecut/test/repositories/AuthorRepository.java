package com.ecut.test.repositories;

import com.ecut.test.entitys.DataSource;
import com.ecut.test.generated.tables.Author;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @author Amy
 * @date 2019-07-04 17:50
 * @description:
 */
@Repository
public class AuthorRepository {

    @Autowired
    private DataSource dataSource;

    private DSLContext dsl;

    private Connection conn;

    /**
     * 添加作者
     *
     * @param id ID
     * @param firstName 名
     * @param lastName 姓
     * @return 添加结果
     */
    public boolean insert(int id, String firstName, String lastName) {
        return dsl.insertInto(Author.AUTHOR, Author.AUTHOR.ID, Author.AUTHOR.FIRST_NAME, Author.AUTHOR.LAST_NAME, Author.AUTHOR.DELETED).values(id, firstName, lastName, false).execute() == 1;
    }

    /**
     * 删除用户
     *
     * @param id ID
     * @return 删除结果
     */
    public boolean deleteById(int id) {
        connectDatabase();
        return dsl.update(Author.AUTHOR).set(Author.AUTHOR.DELETED, true).where(Author.AUTHOR.ID.eq(id)).and(Author.AUTHOR.DELETED.isFalse()).execute() == 1;
    }

    /**
     * 根据ID获取作者信息
     *
     * @param id id
     * @return 作者信息
     */
    public com.ecut.test.generated.tables.pojos.Author findById(int id) {
        connectDatabase();
        return dsl.select().from(Author.AUTHOR).where(Author.AUTHOR.ID.eq(id)).and(Author.AUTHOR.DELETED.isFalse()).fetchOptionalInto(com.ecut.test.generated.tables.pojos.Author.class).orElse(null);
    }

    /**
     * 获取所作者信息
     *
     * @return list
     */
    public List<com.ecut.test.generated.tables.pojos.Author> list() {
        connectDatabase();
        return dsl.selectFrom(Author.AUTHOR).where(Author.AUTHOR.DELETED.isFalse()).fetchInto(com.ecut.test.generated.tables.pojos.Author.class);
    }

    private void connectDatabase() {
        String userName = dataSource.getUserName();
        String password = dataSource.getPassword();
        String url = dataSource.getUrl();
        try {
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("数据库连接成功！");
            dsl = DSL.using(conn, SQLDialect.MYSQL);
        } catch (Exception e) {
            System.out.println("数据库连接异常 ！");
        }
    }
}
