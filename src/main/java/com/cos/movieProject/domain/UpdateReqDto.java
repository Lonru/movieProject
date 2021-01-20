package com.cos.movieProject.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateReqDto {
	@NotBlank(message = "제목을 입력하세요")
	private String title;
	@NotNull(message = "평점을 입력하세요")
	private double rating;
}
