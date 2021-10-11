package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoviesManagerTest {
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

    @BeforeEach
    public void setUp() {
        Movie movie1 = new Movie(1, "Оно", "Ужасы", "https://www.themoviedb.org/t/p/original/kSIR8M81ldKXTpw1B7UZtttskDG.jpg");
        Movie movie2 = new Movie(2, "Оно 2", "Ужасы", "https://www.themoviedb.org/t/p/w500/rjM13nwgzt80xAUKXVp9mzRYyHp.jpg");
        Movie movie3 = new Movie(3, "Время", "Ужасы", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m0rqyzs7IbNaXuJvLTubCG40F92.jpg");
    }

    @Test
    public void shouldGetLatestWithoutLimit() {
        MoviesManager manager = new MoviesManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        Movie[] actual = manager.getLatest();
        Movie[] expected = new Movie[]{movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestWithLimit() {
        MoviesManager manager = new MoviesManager(2);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        Movie[] actual = manager.getLatest();
        Movie[] expected = new Movie[]{movie3, movie2};
        assertArrayEquals(expected, actual);
    }
}
