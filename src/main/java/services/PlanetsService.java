package services;


import pojos.Planets;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class PlanetsService {

    private PlanetsApiService api;

    public PlanetsService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(PlanetsApiService.class);
    }

    public Observable<Planets> getAllCountries() {
        return api.getAllplanetas();
    }

}
