import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pojos.Planet;
import pojos.Planets;
import pojos.Starship;
import pojos.Starships;
import rx.Observable;
import rx.schedulers.Schedulers;
import services.Service;


import java.util.ArrayList;
import java.util.concurrent.Executors;

public class AppController {

    public Label lb_planet_name, lb_planet_diameter, lb_planet_rotation_period, lb_planet_orbital_period, lb_planet_gravity, lb_planet_population, lb_planet_climate, lb_planet_terrain, lb_planet_surface_water, lb_planet_created, lb_planet_edited = new Label();
    public Label lb_starship_name, lb_starship_model, lb_starship_starship_class, lb_starship_manufacturer, lb_starship_cost_in_credits, lb_starship_length, lb_starship_crew, lb_starship_passengers, lb_starship_max_atmosphering_speed, lb_starship_hyperdrive_rating, lb_starship_MGLT, lb_starship_cargo_capacity, lb_starship_consumables, lb_starship_created, lb_starship_edited = new Label();
    public ListView planets_list_view, planets_film_list_vew, planets_residents_list_view = new ListView();
    public ListView Starships_list_view, Starships_film_list_view, Starships_pilots_list_view = new ListView();
    //public static ProgressBar load_bar = new ProgressBar();
    public  Button bt_download_data;

    static Planet planet_aux = new Planet();
    static Starship starsip_aux = new Starship();
    ArrayList<Planets> list_plsnets = new ArrayList<>();

    @FXML
    public void downloadData(Event event) {
        //load_bar.setProgress(-1.0);
        ArrayList<Planets> planetslist = new ArrayList<>();

        final Service service = new Service();

        System.out.println("Comenzando descarga . . .");

        Observable<Planets> obplanets = service.getAllPlanets();
        obplanets.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> createListPlanets(planets, this));
        System.out.println("Fin?");
        planet_aux = (Planet)planets_list_view.getFocusModel().getFocusedItem();

        Observable<Starships> obstarships = service.getAllStarships();
        obstarships.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(starships -> createListStarships(starships, this));
        System.out.println("Fin?");
        starsip_aux = (Starship) Starships_list_view.getFocusModel().getFocusedItem();

    }

    public static void createListPlanets(Planets planets, AppController controller){
        ObservableList<Planet> observablelistplsnets = FXCollections.observableArrayList(planets.getResults());
        controller.planets_list_view.setItems(observablelistplsnets);
    }

    public static void createListStarships(Starships starships, AppController controller){
        ObservableList<Starship> observableliststarships = FXCollections.observableArrayList(starships.getResults());
        controller.Starships_list_view.setItems(observableliststarships);
    }

    @FXML
    public void planetListView (Event event){

        planet_aux = (Planet)planets_list_view.getFocusModel().getFocusedItem();
        ObservableList<String> observablelistfilms = FXCollections.observableArrayList(planet_aux.getFilms());
        ObservableList<String> observablelistresidents = FXCollections.observableArrayList(planet_aux.getResidents());

        lb_planet_name.setText(planet_aux.getName());
        lb_planet_diameter.setText(planet_aux.getDiameter());
        lb_planet_rotation_period.setText(planet_aux.getRotation_period());
        lb_planet_orbital_period.setText(planet_aux.getOrbital_period());
        lb_planet_gravity.setText(planet_aux.getGravity());
        lb_planet_population.setText(planet_aux.getPopulation());
        lb_planet_climate.setText(planet_aux.getClimate());
        lb_planet_terrain.setText(planet_aux.getTerrain());
        lb_planet_surface_water.setText(planet_aux.getSurface_water());
        planets_film_list_vew.setItems(observablelistfilms);
        planets_residents_list_view.setItems(observablelistresidents);
        lb_planet_created.setText(planet_aux.getCreated());
        lb_planet_edited.setText(planet_aux.getEdited());
    }

    @FXML
    public void starsipsListView(Event event){

        starsip_aux = (Starship)Starships_list_view.getFocusModel().getFocusedItem();
        ObservableList<String> observablelistfilms = FXCollections.observableArrayList(starsip_aux.getFilms());
        ObservableList<String> observablelistpilots = FXCollections.observableArrayList(starsip_aux.getPilots());

        lb_starship_name.setText(planet_aux.getName());
        lb_starship_model.setText(starsip_aux.getModel());
        lb_starship_starship_class.setText(starsip_aux.getStarship_class());
        lb_starship_manufacturer.setText(starsip_aux.getManufacturer());
        lb_starship_cost_in_credits.setText(starsip_aux.getCost_in_credits());
        lb_starship_length.setText(starsip_aux.getLength());
        lb_starship_crew.setText(starsip_aux.getCrew());
        lb_starship_passengers.setText(starsip_aux.getPassengers());
        lb_starship_max_atmosphering_speed.setText(starsip_aux.getMax_atmosphering_speed());
        lb_starship_hyperdrive_rating.setText(starsip_aux.getHyperdrive_rating());
        lb_starship_MGLT.setText(starsip_aux.getMGLT());
        lb_starship_cargo_capacity.setText(starsip_aux.getCargo_capacity());
        lb_starship_consumables.setText(starsip_aux.getConsumables());
        Starships_film_list_view.setItems(observablelistfilms);
        Starships_pilots_list_view.setItems(observablelistpilots);
        lb_starship_created.setText(starsip_aux.getCreated());
        lb_starship_edited.setText(starsip_aux.getEdited());

    }

}
