package org.zerock.domain.ex01;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class EmployeeDto {
	private int id;
	private String firstName;
	private String lastName;
	
	// @DateTimeFormat(pattern = "yyyy-MM-dd") 날짜의 형식을 정해주는 어노테이션
	@DateTimeFormat(iso = ISO.DATE) // 표준형식이기 때문에 DateTimeFormat을 제공해줌.
	private LocalDate birthDate;
	private String photo;
	private String notes;
}
