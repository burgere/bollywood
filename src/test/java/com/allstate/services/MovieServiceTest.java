package com.allstate.services;

import com.allstate.entities.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 2/3/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateMovie() throws Exception {
        Movie before = new Movie();
        before.setTitle("The Matrix");
        Movie after = this.movieService.create(before);
        assertEquals(true, after.getId() > 0);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotCreateMovieNoTitle() throws Exception {
        Movie before = new Movie();
        Movie after = this.movieService.create(before);
        assertEquals(true, after.getId() > 0);
    }

    @Test
    public void shouldFindMovieById() throws Exception {
        Movie movie = this.movieService.findById(2);
        assertEquals("Dude, Where\'s My Car?", movie.getTitle());
    }

    @Test
    public void shouldNotFindMovieByInvalidId() throws Exception {
        Movie movie = this.movieService.findById(5);
        assertNull(movie);
    }

    @Test
    public void shouldFindAllTheMovies() throws Exception {
        ArrayList<Movie> movies = (ArrayList<Movie>) this.movieService.findAll();
        assertEquals(3, movies.size());
    }

    @Test
    public void shouldFindMovieByTitle() throws Exception {
        Movie movie = this.movieService.findByTitle("Dumb and Dumber Too");
        assertEquals("PG", movie.getRating());
        assertEquals("Dumb and Dumber Too", movie.getTitle());
    }

    @Test
    public void shouldFindNoMovieByTitle() throws Exception {
        Movie movie = this.movieService.findByTitle("Sherlock Holmes");
        assertNull(movie);
    }

    @Test
    public void shouldDeleteMovieById() throws Exception {

    }
}