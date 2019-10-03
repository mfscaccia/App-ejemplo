package com.challengeappmarceloscaccia.com.myapplication.Interfaces;
import com.challengeappmarceloscaccia.com.myapplication.models.Localizacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocalizacionesAPI {

    String BASE_URL = "http://api.habitissimo.es/location/";
    @GET("list")
    Call<List<Localizacion>> getLocalizaciones();
}
