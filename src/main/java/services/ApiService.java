package services;


import pojos.Planets;
import pojos.Starships;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {

    @GET("planets/")
    Observable<Planets> getAllplanetas();

    @GET("starships/")
    Observable<Starships> getAllstarships();
}
