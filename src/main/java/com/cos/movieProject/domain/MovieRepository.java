package com.cos.movieProject.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "너에게 난", 9.9, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(2, "해질녘 노을처럼", 8.4, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(3, "한편의 아름다운", 8.9, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(4, "추억이 되고", 6.4, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(5, "소중했던", 7.2, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(6, "우리 푸르던 날을", 8.6, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(7, "기억하며", 9.1, new Timestamp(System.currentTimeMillis())));
		movies.add(new Movie(8, "음 후회없이", 7.8, new Timestamp(System.currentTimeMillis())));
		return movies;
	}
	public Movie findById(int id) {
		List<Movie> movies = findAll();

		for (Movie movie : movies) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}
	public void register(RegisterReqDto dto) {
		System.out.println("영화 register() : ");
	}
	
	public void delete(int id) {
		System.out.println(id+"번 영화 delete()");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println(id+"번 영화 update() : ");
	}
}
