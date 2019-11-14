package com.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtendResource extends CommonResource {
	private Set<BaseResource> belongTos;
	private Set<BaseResource> forms;
	private Set<BaseResource> groups;
}
