package com.cos.movieProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
	private int id;
	private String title;
	private double rating;
	private Timestamp makeDate;
}
