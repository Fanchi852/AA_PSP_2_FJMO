package services;


import pojos.Planets;
import retrofit2.http.GET;
import rx.Observable;

public interface PlanetsApiService {

    @GET("planets/")
    Observable<Planets> getAllplanetas();
}
