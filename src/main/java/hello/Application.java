package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public Movie home() {

        RestTemplate restTemplate = new RestTemplate();
        Set<Actor> actors = restTemplate.exchange(
                    System.getenv("ACTORS_ENDPOINT"),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Set<Actor>>(){}
                ).getBody();
        Set<Writer> writers = new HashSet<>(Arrays.asList(new Writer("George Lucas")));
        Movie movie = new Movie("Star Wars: Episode IV - A New Hope", actors, writers);

        return movie;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}