package com.RatingService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document("ratings")
public class Ratings {

	@Id
	@Field(targetType = FieldType.INT64)
	private Integer id;
	private String userId;
	private String hotelId;
	private String feedBack;
	private int ratings;
}
