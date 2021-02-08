package rk.interview.appone.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import rk.interview.appone.entity.Developer;

@Getter
@Setter
public class DeveloperDTO {

	private String name;
	@JsonProperty("phone_number")
	private String phoneNumber;

	public Developer toDeveloper() {
		Developer dev = new Developer();
		dev.setName(name);
		dev.setPhoneNumber(phoneNumber);
		return dev;
	}
}
