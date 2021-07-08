package org.lilaco.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
// 굳이 Lombok 을 사용할 이유가 있을까?
public class SampleHotel {

	private Chef chef;

	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
}