package com.challengeappmarceloscaccia.com.myapplication.Interfaces;

import com.challengeappmarceloscaccia.com.myapplication.models.Subcategorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SubcategoriasAPI {

    String BASE_URL = "http://api.habitissimo.es/category/";

    @GET("list/{id}")
    Call<List<Subcategorias>> getSubcategoria(@Path("id") String id);
}


