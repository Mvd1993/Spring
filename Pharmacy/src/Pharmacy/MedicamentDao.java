package Pharmacy;

import java.util.*;
import java.sql.*;

public class MedicamentDao {

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

	public static int save(Medicament medicament) {
		int status = 0;
		
		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("insert into MEDICAMENT (medicamentId,name, description,producer, "
							+ "category,price,stock_Quantity, stock_In_Order,active) values (?,?,?,?,?,?,?,?,?)");
			preparedStatment.setString(1, medicament.getMedicamentId());
			preparedStatment.setString(2, medicament.getName());
			preparedStatment.setString(3, medicament.getDescription());
			preparedStatment.setString(4, medicament.getProducer());
			preparedStatment.setString(5, medicament.getCategory());
			preparedStatment.setDouble(6, medicament.getPrice());
			preparedStatment.setDouble(7, medicament.getStockQuantity());
			preparedStatment.setDouble(8, medicament.getStockInOrder());
			preparedStatment.setBoolean(9, medicament.getActive());
			

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Medicament medicament) {

		int status = 0;
		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("update MEDICAMENT set name=?,description=?,producer=?,category=?,"
							+ "price=?,stock_Quantity=?,stock_In_Order=?, active=? where medicamentId=?");

			
			preparedStatment.setString(1, medicament.getName());
			preparedStatment.setString(2, medicament.getDescription());
			preparedStatment.setString(3, medicament.getProducer());
			preparedStatment.setString(4, medicament.getCategory());
			preparedStatment.setDouble(5, medicament.getPrice());
			preparedStatment.setDouble(6, medicament.getStockQuantity());
			preparedStatment.setDouble(7, medicament.getStockInOrder());
			preparedStatment.setBoolean(8, medicament.getActive());

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

			Connection connection = MedicamentDao.getConnection();
			PreparedStatement prepareStatment = connection.prepareStatement("delete from MEDICAMENT where medicamentID=?");

			prepareStatment.setInt(1, id);
			status = prepareStatment.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Medicament getMedicamentById(int idMedicament) {

		Medicament medicament = new Medicament();

		try {
			Connection connection = MedicamentDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("select * from MEDICAMENT where medicamentID=?");
			preparedStatment.setInt(1, idMedicament);

			ResultSet rs = preparedStatment.executeQuery();
			if (rs.next()) {
				
				medicament.setMedicamentId(rs.getString(1));
				medicament.setName(rs.getString(2));
				medicament.setDescription(rs.getString(3));
				medicament.setProducer(rs.getString(4));
				medicament.setCategory(rs.getString(5));
				medicament.setPrice(rs.getDouble(6));
				medicament.setStockQuantity(rs.getLong(7));
				medicament.setStockInOrder(rs.getLong(8));
				medicament.setActive(rs.getBoolean(9));
								
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return medicament;
	}

	public static List<Medicament> getAllMedicaments() {
		List<Medicament> list = new ArrayList<Medicament>();

		try {
			Connection connnection = MedicamentDao.getConnection();
			PreparedStatement preparedStatement = connnection.prepareStatement("select * from MEDICAMENT");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Medicament medicament = new Medicament();
				medicament.setMedicamentId(rs.getString(1));
				medicament.setName(rs.getString(2));
				medicament.setDescription(rs.getString(3));
				medicament.setProducer(rs.getString(4));
				medicament.setCategory(rs.getString(5));
				medicament.setPrice(rs.getDouble(6));
				medicament.setStockQuantity(rs.getLong(7));
				medicament.setStockInOrder(rs.getLong(8));
				medicament.setActive(rs.getBoolean(9));
				list.add(medicament );
			}
			connnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}