package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public Movie home() {

        Set<Actor> actors = new HashSet<>(Arrays.asList(new Actor("George Lucas")));
        Set<Writer> writers = new HashSet<>(Arrays.asList(new Writer("George Lucas")));
        Movie movie = new Movie("Star Wars: Episode IV - A New Hope", actors, writers);

        return movie;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}