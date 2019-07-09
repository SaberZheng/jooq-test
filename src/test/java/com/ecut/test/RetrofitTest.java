package com.ecut.test;

import com.ecut.test.entitys.Repo;
import com.ecut.test.generated.tables.pojos.Author;
import com.ecut.test.services.AuthorRetrofitService;
import com.ecut.test.services.GitHubService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Amy
 * @date 2019-07-08 16:25
 * @description:
 */
public class RetrofitTest {

    /**
     * Retrofit 将HTTP API 转为 Java 接口。
     */
    @Test
    public void test() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("SaberZheng");

        // 同步调用
        List<Repo> data = repos.execute().body();
        Assert.assertNotNull(data);
        System.out.println(data.toString());
    }

    @Test
    public void testFindAuthorById() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/jooq/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        AuthorRetrofitService service = retrofit.create(AuthorRetrofitService.class);
        Call<Author> repos = service.findAuthorById(1);

        // 同步调用
        Author data = repos.execute().body();
        Assert.assertNotNull(data);
        System.out.println(data.toString());

    }

    @Test
    public void testListAuthors() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/jooq/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        AuthorRetrofitService service = retrofit.create(AuthorRetrofitService.class);
        Call<List<Author>> repos = service.listAuthors();

        // 同步调用
        List<Author> data = repos.execute().body();
        Assert.assertTrue(!CollectionUtils.isEmpty(data));
        System.out.println(data.toString());

    }

    @Test
    public void testDeleteAuthor() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/jooq/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        AuthorRetrofitService service = retrofit.create(AuthorRetrofitService.class);
        Call<Boolean> repos = service.delete(1);
        // 同步调用
        Boolean data = repos.execute().body();
        System.out.println(data);

    }

    @Test
    public void testInsertAuthor() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/jooq/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        AuthorRetrofitService service = retrofit.create(AuthorRetrofitService.class);
        Map<String , String> author = new HashMap<>();
        author.put("id","7");
        author.put("firstName","seven");
        author.put("lastName","zheng");
        Call<Boolean> repos = service.insertAuthor(author);
        // 同步调用
        Boolean data = repos.execute().body();
        System.out.println(data);

    }

}
