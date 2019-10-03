package com.challengeappmarceloscaccia.com.myapplication.Interfaces;

import com.challengeappmarceloscaccia.com.myapplication.models.Categorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriasAPI {

    String BASE_URL = "http://api.habitissimo.es/category/";
    @GET("list")
    Call<List<Categorias>> getCategorias();
}
