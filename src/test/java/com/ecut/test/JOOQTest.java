package com.ecut.test;

import com.ecut.test.generated.tables.Author;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JOOQTest
{
    @Test
    public void test()
    {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/library";
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("数据库连接成功！");
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(Author.AUTHOR).fetch();
            System.out.println(result);
            for (Record r : result) {
                Integer id = r.getValue(Author.AUTHOR.ID);
                String firstName = r.getValue(Author.AUTHOR.FIRST_NAME);
                String lastName = r.getValue(Author.AUTHOR.LAST_NAME);
                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
