package org.zerock.mapper.ex02;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
	
	@Select("SELECT EmployeeID id, FirstName, LastName, Photo, Notes, BirthDate "
			+ "FROM Employees ORDER BY EmployeeID ")
	List<EmployeeDto> listEmployee();

	@Select("SELECT CustomerID id, CustomerName, ContactName, Address, "
			+ "City, PostalCode, Country FROM Customers ORDER BY CustomerID ")
	List<CustomerDto> listCustomer();
	
	@Select("SELECT CustomerID id, CustomerName, ContactName, Address, "
			+ "City, PostalCode, Country FROM Customers ORDER BY CustomerID LIMIT #{from }, #{row}")
	List<CustomerDto> listCustomerPage(@Param("from")int from, @Param("row")int row); 
	// 매개변수가 2개이상일 경우 #{}를 그냥 못씀 -> 컴파일시 매개변수명을 잃어버려서 뭐가 뭔지 모름
	// mybatis에서 @param 어노테이션을 제공하여 컴파일시에도 매개변수명을 잃어버리지 않게 명시할수 있게 됨
	// @param()에 ("")안에 매개변수명을 명시하면 쿼리에서 #{} 사용가능
	// 쿼리가 길어지면 어노테이션으로 보기 힘듬. 그래서 xml파일로 따로 쿼리문을 빼서 작성
	
	@Select("SELECT Count(CustomerID) FROM Customers")
	int countCustomers();
}
