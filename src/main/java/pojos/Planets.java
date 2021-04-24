package pojos;

import javafx.collections.ObservableList;
import rx.Observable;

import java.util.ArrayList;

public class Planets {

    private String count, next, previous;
    private ObservableList<Planet> results;

    public Planets() {
    }

    public Planets(String count, String next, String previous, ObservableList<Planet> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ObservableList<Planet> getResults() {
        return results;
    }

    public void setResults(ObservableList<Planet> results) {
        this.results = results;
    }
}
