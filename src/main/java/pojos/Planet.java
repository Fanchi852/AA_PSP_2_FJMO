package pojos;

import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Planet {

    private String name, diameter, rotation_period, orbital_period, gravity, population, climate, terrain, surface_water, edited , created;
    private ObservableList<String> films, residents ;
    private PropertyChangeSupport support;

    public Planet() {
        support = new PropertyChangeSupport(this);
    }

    public Planet(String name, String diameter, String rotation_period, String orbital_period, String gravity, String population, String climate, String terrain, String surface_water, String edited, String created, ObservableList<String> films, ObservableList<String> residents) {
        this.name = name;
        this.diameter = diameter;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.gravity = gravity;
        this.population = population;
        this.climate = climate;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.edited = edited;
        this.created = created;
        this.films = films;
        this.residents = residents;
        support = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ObservableList<String> getFilms() {
        return films;
    }

    public void setFilms(ObservableList<String> films) {
        this.films = films;
    }

    public ObservableList<String> getResidents() {
        return residents;
    }

    public void setResidents(ObservableList<String> residents) {
        this.residents = residents;
    }

    public void addObserver(PropertyChangeListener observer) {
        support.addPropertyChangeListener(observer);
    }

    public void removeObserver(PropertyChangeListener observer) {
        support.removePropertyChangeListener(observer);
    }

    public void copyAndTell(Planet planet){
        support.firePropertyChange("planet",this, planet);
        this.name = planet.getName();
        this.diameter = planet.getDiameter();
        this.rotation_period = planet.getRotation_period();
        this.orbital_period = planet.getOrbital_period();
        this.gravity = planet.getGravity();
        this.population = planet.getPopulation();
        this.climate = planet.getClimate();
        this.terrain = planet.getTerrain();
        this.surface_water = planet.getSurface_water();
        this.edited = planet.getEdited();
        this.created = planet.getCreated();
        this.films = planet.getFilms();
        this.residents = planet.getResidents();
    }
}


