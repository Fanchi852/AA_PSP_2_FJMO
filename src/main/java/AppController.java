import rx.schedulers.Schedulers;
import services.PlanetsService;

import java.util.concurrent.Executors;

public class AppController {

    public static void AppController(String[] args) {
        final PlanetsService countriesService = new PlanetsService();

        System.out.println("Comenzando descarga . . .");

        countriesService.getAllCountries()

                .doOnCompleted(() -> System.out.println("Listado de países descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(System.out::println);



        System.out.println("Fin?");
    }

}
