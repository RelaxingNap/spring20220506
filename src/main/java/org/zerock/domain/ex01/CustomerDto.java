package org.zerock.domain.ex01;

import lombok.Data;

@Data
public class CustomerDto {
	private int id;
	private String name;
	private String customerName;
	private String address;
	private String city;
	private String country;
	private String contactName;
	private String postalCode;
}
