package services;


import pojos.Planet;
import pojos.Planets;
import pojos.Starships;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Service {

    private ApiService api;

    public Service() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(ApiService.class);
    }

    public Observable<Planets> getPage1planets() {return api.getPage1planets();}
    public Observable<Planets> getPage2planets() {return api.getPage2planets();}
    public Observable<Planets> getPage3planets() {return api.getPage3planets();}
    public Observable<Planets> getPage4planets() {return api.getPage4planets();}
    public Observable<Planets> getPage5planets() {return api.getPage5planets();}
    public Observable<Planets> getPage6planets() {return api.getPage6planets();}

    public Observable<Starships> getPage1starships() {
        return api.getPage1starships();
    }
    public Observable<Starships> getPage2starships() {
        return api.getPage2starships();
    }
    public Observable<Starships> getPage3starships() {
        return api.getPage3starships();
    }
    public Observable<Starships> getPage4starships() {
        return api.getPage4starships();
    }

}
