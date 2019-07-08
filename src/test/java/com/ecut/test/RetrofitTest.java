package com.ecut.test;

import com.ecut.test.entitys.Repo;
import com.ecut.test.services.GitHubService;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author Amy
 * @date 2019-07-08 16:25
 * @description:
 */
public class RetrofitTest {

    /**
     * Retrofit 将HTTP API 转为 Java 接口。
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("SaberZheng");

        // 同步调用
        List<Repo> data = repos.execute().body();
        System.out.println(data.toString());

        // 异步调用
       /* repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> data = response.body();
                System.out.println(data.toString());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/
    }

}
