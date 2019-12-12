package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResource extends BaseResource {
	private String code;
	private String name;
	private Long parentId;
	private Boolean active;
	private Boolean visibility;
}
