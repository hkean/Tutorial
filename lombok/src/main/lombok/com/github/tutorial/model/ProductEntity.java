package com.github.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

	private Long id;

	private String name;

	private Boolean isActive;
	
	private Boolean isDeleted;
	
}
