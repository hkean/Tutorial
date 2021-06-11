package com.github.tutorial.model.builder;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class Week {
	private Long id;
	private Integer year;
	private Integer month;
	private Integer weekOfYear;
	private Date startDate;
	private Date endDate;
}
