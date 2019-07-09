package com.ecut.test.services;

import com.ecut.test.generated.tables.pojos.Author;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * @author Amy
 * @date 2019-07-09 11:08
 * @description:
 */
public interface AuthorRetrofitService {

    @FormUrlEncoded
    @POST("testSwagger/addAuthor")
    Call<Boolean> insertAuthor(@FieldMap Map<String, String> options);

    @FormUrlEncoded
    @POST("testSwagger/deleteAuthor")
    Call<Boolean> delete(@Field("id") int id);

    @GET("testSwagger/listAuthors")
    Call<List<Author>> listAuthors();

    @GET("testSwagger/findAuthorById")
    Call<Author> findAuthorById(@Query("id")int id);


}
