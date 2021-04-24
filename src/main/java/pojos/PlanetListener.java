package pojos;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlanetListener implements PropertyChangeListener {

        private Planet planet;
        private Boolean planetchange = new Boolean(false);

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if(planet.equals((Planet)evt.getNewValue())){
            planetchange = false;
        }else{
            planet = (Planet)evt.getNewValue();
            planetchange = false;
        }
    }

    public PlanetListener() {
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Boolean getPlanetchange() {
        return planetchange;
    }

    public void setPlanetchange(Boolean planetchange) {
        this.planetchange = planetchange;
    }
}
