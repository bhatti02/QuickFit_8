package io.github.taimoor.workoutTrainer.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkAdaptar {

    public static ApiInterface getClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiInterface.class);
    }
}
