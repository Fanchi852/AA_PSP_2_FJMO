package services;


import pojos.Planets;
import pojos.Starships;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {


    @GET("planets/?page=1")
    Observable<Planets> getPage1planets();
    @GET("planets/?page=2")
    Observable<Planets> getPage2planets();
    @GET("planets/?page=3")
    Observable<Planets> getPage3planets();
    @GET("planets/?page=4")
    Observable<Planets> getPage4planets();
    @GET("planets/?page=5")
    Observable<Planets> getPage5planets();
    @GET("planets/?page=6")
    Observable<Planets> getPage6planets();

    @GET("starships/?page=1")
    Observable<Starships> getPage1starships();
    @GET("starships/?page=2")
    Observable<Starships> getPage2starships();
    @GET("starships/?page=3")
    Observable<Starships> getPage3starships();
    @GET("starships/?page=4")
    Observable<Starships> getPage4starships();
}
