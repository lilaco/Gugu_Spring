package org.lilaco.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class Restaurant {
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
