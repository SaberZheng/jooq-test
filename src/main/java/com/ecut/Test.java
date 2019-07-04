package com.ecut;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.ecut.generated.tables.Author.AUTHOR;

/**
 * @author Amy
 * @date 2019-07-04 16:50
 * @description: 测试类
 */
public class Test {

    public static void main(String[] args) {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/library";
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("数据库连接成功！");
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(AUTHOR).fetch();
            System.out.println(result);
            for (Record r : result) {
                Integer id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);
                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
