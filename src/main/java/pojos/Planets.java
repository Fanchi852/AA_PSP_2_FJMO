package pojos;

import javafx.collections.ObservableList;
import rx.Observable;

import java.util.ArrayList;

public class Planets {

    private String count, next, previous;
    private ArrayList<Planet> results;

    public Planets() {
    }

    public Planets(String count, String next, String previous, ArrayList<Planet> results) {
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

    public ArrayList<Planet> getResults() {
        return results;
    }

    public void setResults(ArrayList<Planet> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Planets{" +
                "count='" + count + '\'' +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
