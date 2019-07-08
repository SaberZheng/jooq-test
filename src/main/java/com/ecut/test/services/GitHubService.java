package com.ecut.test.services;

import com.ecut.test.entitys.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author Amy
 * @date 2019-07-08 15:33
 * @description: 使用Retrofit访问GitHub的api的service
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
