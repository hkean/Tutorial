package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LookupResource extends ExtendResource {

	private Boolean withText;
	private Boolean multiChild;
	private String section;
	private Integer intId;
}
