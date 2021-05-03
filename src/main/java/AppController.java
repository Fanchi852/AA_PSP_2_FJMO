import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pojos.Planet;
import pojos.Planets;
import pojos.Starship;
import pojos.Starships;
import rx.Observable;
import rx.schedulers.Schedulers;
import services.Service;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class AppController {

    public Label lb_planet_name, lb_planet_diameter, lb_planet_rotation_period, lb_planet_orbital_period, lb_planet_gravity, lb_planet_population, lb_planet_climate, lb_planet_terrain, lb_planet_surface_water, lb_planet_created, lb_planet_edited = new Label();
    public Label lb_starship_name, lb_starship_model, lb_starship_starship_class, lb_starship_manufacturer, lb_starship_cost_in_credits, lb_starship_length, lb_starship_crew, lb_starship_passengers, lb_starship_max_atmosphering_speed, lb_starship_hyperdrive_rating, lb_starship_MGLT, lb_starship_cargo_capacity, lb_starship_consumables, lb_starship_created, lb_starship_edited = new Label();
    public Label lb_searchin = new Label();
    public ListView planets_list_view, planets_film_list_vew, planets_residents_list_view = new ListView();
    public ListView Starships_list_view, Starships_film_list_view, Starships_pilots_list_view = new ListView();
    public ProgressBar load_bar = new ProgressBar();
    public ComboBox cb_search = new ComboBox();
    public TextField tf_name_search = new TextField();

    public String pag = "1";

    static Planet planet_aux = new Planet();
    static ArrayList<Planet> planetlist = new ArrayList<>();
    static Starship starsip_aux = new Starship();
    static ArrayList<Starship> starshiplist = new ArrayList<>();
    static Map<String,Boolean> chekplanet = new HashMap();
    static Map<String,Boolean> chekstarships = new HashMap();
    static Map<String,Boolean> chekprogres = new HashMap();


    @FXML
    public void downloadData(Event event) {

        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("Planetas", "Naves");
        cb_search.setItems(items);
        cb_search.setValue("Planetas");
        cb_search.setDisable(false);
        tf_name_search.setDisable(false);

        planetlist.clear();
        starshiplist.clear();
        planets_list_view.getItems().clear();
        Starships_list_view.getItems().clear();

        final Service service = new Service();

        chekplanet.put("ppag1", false);
        chekplanet.put("ppag2", false);
        chekplanet.put("ppag3", false);
        chekplanet.put("ppag4", false);
        chekplanet.put("ppag5", false);
        chekplanet.put("ppag6", false);

        chekstarships.put("spag1", false);
        chekstarships.put("spag2", false);
        chekstarships.put("spag3", false);
        chekstarships.put("spag4", false);

        chekprogres.putAll(chekplanet);
        chekprogres.putAll(chekstarships);

        System.out.println("Comenzando descarga . . .");

        Observable<Planets> obplanets1 = service.getPage1planets();
        obplanets1.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> addinPlanetsList(planets));

        Observable<Planets> obplanets2 = service.getPage2planets();
        obplanets2.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> addinPlanetsList(planets));

        Observable<Planets> obplanets3 = service.getPage3planets();
        obplanets3.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> addinPlanetsList(planets));

        Observable<Planets> obplanets4 = service.getPage4planets();
        obplanets4.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> addinPlanetsList(planets));

        Observable<Planets> obplanets5 = service.getPage5planets();
        obplanets5.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> addinPlanetsList(planets));

        Observable<Planets> obplanets6 = service.getPage6planets();
        obplanets6.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(planets -> addinPlanetsList(planets));

        Observable<Starships> obstarships1 = service.getPage1starships();
        obstarships1.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(starships -> addinStarshpsList(starships));

        Observable<Starships> obstarships2 = service.getPage2starships();
        obstarships2.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(starships -> addinStarshpsList(starships));

        Observable<Starships> obstarships3 = service.getPage3starships();
        obstarships3.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(starships -> addinStarshpsList(starships));

        Observable<Starships> obstarships4 = service.getPage4starships();
        obstarships4.doOnCompleted(() -> System.out.println("Listado descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(starships -> addinStarshpsList(starships));

    }

    public void addinPlanetsList(Planets planets){

        planetlist.addAll(planets.getResults());

        Integer page = 0;
        String pagestr = "";
        if (planets.getNext()==null){
            page = Integer.valueOf(planets.getPrevious().split("=")[1])+1;
            System.out.println("valor de la paguina cuando es null" + page);
        }else{
            page = Integer.valueOf(planets.getNext().split("=")[1])-1;
            System.out.println("valor de la paguina cuando no es null" + page);
        }
        pagestr = "ppag"+page;

        chekplanet.put(pagestr, true);

        Boolean allpagloaded = true;
        for (Boolean loaded : chekplanet.values()){
            if (!loaded){
                allpagloaded = false;
            }
        }

        if (allpagloaded){
            System.out.println("total planetas: " + planetlist.size());
            createListStarships();
        }
        cheakprogres(pagestr);
    }
    public void addinStarshpsList(Starships starships){
        starshiplist.addAll(starships.getResults());

        Integer page = 0;
        String pagestr = "";
        if (starships.getNext()==null){
            page = Integer.valueOf(starships.getPrevious().split("=")[1])+1;
        }else{
            page = Integer.valueOf(starships.getNext().split("=")[1])-1;
        }
        pagestr = "spag"+page;

        chekstarships.put(pagestr, true);

        Boolean allpagloaded = true;
        for (Boolean loaded : chekstarships.values()){
            if (!loaded){
                allpagloaded = false;
            }
        }

        if (allpagloaded){
            System.out.println("total planetas: " + starshiplist.size());
            createListPlanets();
        }
        cheakprogres(pagestr);
    }

    public void cheakprogres(String page){
        chekprogres.put(page, true);

        Float progres = 0.0f;
        for (Boolean loaded : chekprogres.values()){
            if (loaded){
                progres += 1.0f/chekprogres.keySet().size();
            }
        }

        load_bar.setProgress(progres);
    }

    public void createListPlanets(){
        System.out.println("creando la lista de planetas");
        ObservableList<Planet> observablelistplsnets = FXCollections.observableArrayList(planetlist);
        planets_list_view.setItems(observablelistplsnets);
    }
    public  void createListStarships(){
        System.out.println("creando la lista de naves");
        ObservableList<Starship> observableliststarships = FXCollections.observableArrayList(starshiplist);
        Starships_list_view.setItems(observableliststarships);

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

    @FXML
    public void csvCreator(Event event){
        try {
            CSVWriter wrp = new CSVWriter(new FileWriter("src/main/resources/CSV/planets_csv.csv"));
            for (Planet planet : planetlist){
                wrp.writeNext(planet.toArrayString());
            }
            CSVWriter wrs = new CSVWriter(new FileWriter("src/main/resources/CSV/starships_csv.csv"));
            for (Starship starship : starshiplist){
                wrs.writeNext(starship.toArrayString());
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void search(Event event){

        switch (cb_search.getValue().toString()){
            case "Planetas":
                ArrayList<Planet> planetlist_filter = new ArrayList<>(
                        planetlist
                                .stream()
                                .filter(planet -> planet.getName().equals(tf_name_search.getText()))
                                .collect(Collectors.toList())
                );
                ObservableList<Planet> observablelistplsnets = FXCollections.observableArrayList(planetlist_filter);
                planets_list_view.setItems(observablelistplsnets);
                System.out.println("seleccionado; "+cb_search.getValue().toString()+", nombre: "+tf_name_search.getText());
                break;
            case "Naves":
                ArrayList<Starship> starshiplist_filter = new ArrayList<>(
                        starshiplist
                                .stream()
                                .filter(starship -> starship.getName().equals(tf_name_search.getText()))
                                .collect(Collectors.toList())
                );
                ObservableList<Starship> observableliststarships = FXCollections.observableArrayList(starshiplist_filter);
                Starships_list_view.setItems(observableliststarships);
                System.out.println("seleccionado; "+cb_search.getValue().toString()+", nombre: "+tf_name_search.getText());
                break;
            default:
                System.out.println("se debe de seleccionar una lista en la que realizar el filtrado");
                lb_searchin.setStyle("-fx-background-color: Red;");
                break;
        }
    }
}
