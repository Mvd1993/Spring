package serveletH2;

import java.util.*;
import java.sql.*;

public class EmployeeDao {

	public static Connection getConnection() {

		Connection conection = null;
		try {

			Class.forName("org.h2.Driver");
			conection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/curso", "sa", "sa");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conection;
	}

	public static int save(Employee employee) {
		int status = 0;

		try {
			Connection connection = EmployeeDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("insert into EMPLOYEE (name,password,email,country) values (?,?,?,?)");
			preparedStatment.setString(1, employee.getName());
			preparedStatment.setString(2, employee.getPassword());
			preparedStatment.setString(3, employee.getEmail());
			preparedStatment.setString(4, employee.getCountry());

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Employee employee) {

		int status = 0;
		try {
			Connection connection = EmployeeDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("update EMPLOYEE set name=?,password=?,email=?,country=? where employeeId=?");

			preparedStatment.setString(1, employee.getName());
			preparedStatment.setString(2, employee.getPassword());
			preparedStatment.setString(3, employee.getEmail());
			preparedStatment.setString(4, employee.getCountry());
			preparedStatment.setInt(5, employee.getId());

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;

		try {

			Connection connection = EmployeeDao.getConnection();
			PreparedStatement prepareStatment = connection.prepareStatement("delete from EMPLOYEE where employeeid=?");

			prepareStatment.setInt(1, id);
			status = prepareStatment.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Employee getEmployeeById(int idEmployee) {

		Employee employeee = new Employee();

		try {
			Connection connection = EmployeeDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("select * from EMPLOYEE where employeeid=?");
			preparedStatment.setInt(1, idEmployee);

			ResultSet rs = preparedStatment.executeQuery();
			if (rs.next()) {
				employeee.setId(rs.getInt(1));
				employeee.setName(rs.getString(2));
				employeee.setPassword(rs.getString(3));
				employeee.setEmail(rs.getString(4));
				employeee.setCountry(rs.getString(5));
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return employeee;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();

		try {
			Connection connnection = EmployeeDao.getConnection();
			PreparedStatement preparedStatment = connnection.prepareStatement("select * from EMPLOYEE");
			ResultSet rs = preparedStatment.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee .setId(rs.getInt(1));
				employee .setName(rs.getString(2));
				employee .setPassword(rs.getString(3));
				employee .setEmail(rs.getString(4));
				employee .setCountry(rs.getString(5));
				list.add(employee );
			}
			connnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}