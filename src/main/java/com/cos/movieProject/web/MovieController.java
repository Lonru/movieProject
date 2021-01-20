package com.cos.movieProject.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movieProject.domain.CommonDto;
import com.cos.movieProject.domain.Movie;
import com.cos.movieProject.domain.MovieRepository;
import com.cos.movieProject.domain.RegisterReqDto;
import com.cos.movieProject.domain.UpdateReqDto;

@RestController
public class MovieController {
	private final MovieRepository movieRepository;

	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping("/movie")
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id) {
		return movieRepository.findById(id);
	}
	@PostMapping("/movie")
	public CommonDto<?> register(@Valid @RequestBody RegisterReqDto dto,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
		}
		movieRepository.register(dto);
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	}
	@DeleteMapping("/movie/{id}")
	public CommonDto<?> delete(@PathVariable int id) {
		if (movieRepository.findById(id)!=null) {
			movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
		}
		else 
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
	}
	@PutMapping("/movie/{id}")
	public CommonDto<?> update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto) {
		if (movieRepository.findById(id)!=null) {
			movieRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
		}
		else 
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
	}

}
