import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import pojos.Planet;
import pojos.PlanetListener;
import pojos.Planets;
import pojos.Starship;
import rx.Observable;
import rx.schedulers.Schedulers;
import services.PlanetsService;


import java.util.concurrent.Executors;

public class AppController {

    public Label lb_planet_name, lb_planet_diameter, lb_planet_rotation_period, lb_planet_orbital_period, lb_planet_gravity, lb_planet_population, lb_planet_climate, lb_planet_terrain, lb_planet_surface_water, lb_planet_created, lb_planet_edited = new Label();
    public Label lb_starship_name, lb_starship_model, lb_starship_starship_class, lb_starship_manufacturer, lb_starship_cost_in_credits, lb_starship_length, lb_starship_crew, lb_starship_passengers, lb_starship_max_atmosphering_speed, lb_starship_hyperdrive_rating, lb_starship_MGLT, lb_starship_cargo_capacity, lb_starship_consumables, lb_starship_created, lb_starship_edited = new Label();
    public ListView planets_list_view; //planets_film_list_vew, planets_residents_list_view = new ListView();
    //public ListView Starships_list_view, Starships_film_list_view, Starships_pilots_list_view = new ListView();
    public ProgressBar load_bar;
    public Button bt_download_data;

    Planet planet_aux = new Planet();

    @FXML
    public void downloadData(Event event) {

        System.out.println("el boton funciona");
        load_bar.setProgress(-1.0);

        final PlanetsService planetsService = new PlanetsService();

        System.out.println("Comenzando descarga . . .");

        Observable<Planets> obplanets = planetsService.getAllPlanets();

        obplanets.doOnCompleted(() -> System.out.println("Listado de países descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> planets_list_view.setItems(planets.getResults())
                );
        System.out.println("Fin?");

        PlanetListener plistener = new PlanetListener();
        planet_aux.addObserver(plistener);

        planet_aux.copyAndTell((Planet)planets_list_view.getFocusModel().getFocusedItem());


        while (!plistener.getPlanetchange()){
            System.out.println("este texto va a salir un par de veces");
        }

        print_Planet();
        print_starships();
        load_bar.setProgress(1.0);

    }

    public void print_Planet (){



        lb_planet_name.setVisible(true);
        lb_planet_name.setText(planet_aux.getName());
        lb_planet_diameter.setVisible(true);
        lb_planet_diameter.setText(planet_aux.getDiameter());
        lb_planet_rotation_period.setVisible(true);
        lb_planet_rotation_period.setText(planet_aux.getRotation_period());
        lb_planet_orbital_period.setVisible(true);
        lb_planet_orbital_period.setText(planet_aux.getOrbital_period());
        lb_planet_gravity.setVisible(true);
        lb_planet_gravity.setText(planet_aux.getGravity());
        lb_planet_population.setVisible(true);
        lb_planet_population.setText(planet_aux.getPopulation());
        lb_planet_climate.setVisible(true);
        lb_planet_climate.setText(planet_aux.getClimate());
        lb_planet_terrain.setVisible(true);
        lb_planet_terrain.setText(planet_aux.getTerrain());
        lb_planet_surface_water.setVisible(true);
        lb_planet_surface_water.setText(planet_aux.getSurface_water());
        lb_planet_created.setVisible(true);
        lb_planet_created.setText(planet_aux.getCreated());
        lb_planet_edited.setVisible(true);
        lb_planet_edited.setText(planet_aux.getEdited());

        //planets_film_list_vew.setItems(planet.getFilms());
        //planets_residents_list_view.setItems(planet.getResidents());
    }

    public void print_starships(){

    }

}
