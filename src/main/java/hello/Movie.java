package hello;

import java.util.HashSet;
import java.util.Set;

public class Movie {

    public String title;
    private Set<Actor> actors = new HashSet<>();
    private Set<Writer> writers = new HashSet<>();

    public Set<Actor> getActors() {
        return actors;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public String getTitle(){
        return title;
    }

    Movie(String title, Set<Actor> actors, Set<Writer> writers){
        this.title = title;
        this.actors = actors;
        this.writers = writers;
    }

    Movie(){

    }
}