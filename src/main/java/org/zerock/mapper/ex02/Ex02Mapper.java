package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;

public interface Ex02Mapper {
	// 서비스에서 시키는 일을 받아서 DB에 쿼리를 작성하여 결과를 가져오는 인터페이스
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}")
	String selectNameById(int id);
	
	@Select("SELECT FirstName FROM Employees WHERE EmployeeID = #{id}")
	String getFirstNameById(int id);
	
	@Select("SELECT CustomerName Name, Address, City, Country FROM Customers WHERE CustomerID = #{id }")
	CustomerDto selectCustomerById(int id);
	// Mybatis가 알아서 세팅해줌
	// CustomerDto와 Select의 컬럼명과 일치해야 자동으로 들어가게됨.
	// CustomerDto와 Select의 컬럼명이 다를경우 쿼리에서 별칭을 통해 일치하게 만들면 가능
	
	@Select("SELECT FirstName, LastName, BirthDate FROM Employees WHERE EmployeeID = #{id }")
	EmployeeDto selectEmployeeById(int id);
	// Mybatis가 Date의 type을 알아서 형변환하여 맞추어줌.
	
	@Insert("INSERT INTO Customers "
			+ "(CustomerName, ContactName, City, Country, Address, PostalCode) "
			+ "VALUES (#{customerName}, #{contactName}, #{city}, #{country}, #{address}, #{postalCode})")
	int insertCustomer(CustomerDto customer);
	
	@Insert("INSERT INTO Employees "
			+ "(LastName, FirstName, BirthDate, Photo, Notes) "
			+ "VALUES (#{lastName}, #{firstName}, #{birthDate}, #{photo}, #{notes}) ")
	int insertEmployee(EmployeeDto employee);
}
