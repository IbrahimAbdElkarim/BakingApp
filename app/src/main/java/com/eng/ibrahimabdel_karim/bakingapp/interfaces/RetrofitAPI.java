package com.eng.ibrahimabdel_karim.bakingapp.interfaces;

import com.eng.ibrahimabdel_karim.bakingapp.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ibrahimAbdelKarim on 13/07/2017.
 */

public interface RetrofitAPI {
    @GET("baking.json")
    Call<List<Recipe>> getJson();
}
