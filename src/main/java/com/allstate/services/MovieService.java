package com.allstate.services;

import com.allstate.entities.Movie;
import com.allstate.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository repository;

    public Movie create(Movie m) {
        return this.repository.save(m);
    }

    @Autowired
    public void setRepository(IMovieRepository repository) {
        this.repository = repository;
    }

    public Movie findById(int id) {
        return this.repository.findOne(id);
    }

    public Iterable<Movie> findAll() {
        return this.repository.findAll();
    }

    public Movie findByTitle(String title) {
        return this.repository.findByTitle(title);
    }
}
