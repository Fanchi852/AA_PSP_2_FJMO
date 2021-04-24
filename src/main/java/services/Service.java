package services;


import pojos.Planets;
import pojos.Starships;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

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

    public Observable<Planets> getAllPlanets() {
        return api.getAllplanetas();
    }

    public Observable<Starships> getAllStarships() {
        return api.getAllstarships();
    }

}
