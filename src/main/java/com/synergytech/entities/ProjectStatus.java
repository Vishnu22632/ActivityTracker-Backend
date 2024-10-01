package com.synergytech.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ProjectStatus {

	PENDING,
	ONGOING,
	COMPLETED
	
}


