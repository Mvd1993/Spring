package com.java.so;

import java.util.*;
import java.util.List;
import java.sql.*;

public class MedicamentDao {
	
public static Connection getConnection() {	
	Connection conection = null;
    try {

        Class.forName("org.h2.Driver");
        conection = DriverManager.getConnection("jdbc:h2:~/curso", "sa", "sa");
        System.out.println("CONNECTION OK");
    } catch (Exception e) {
    	System.out.println("CONNECTION PROBLEM");
        System.out.println(e);
    }
    return conection;
}

public static List<Medicament> getAllMedicament() {
    List<Medicament> list = new ArrayList<Medicament>();

    try {
        Connection con = MedicamentDao.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM MEDICAMENT");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	
            Medicament e = new Medicament();
            e.setMedicamentId(rs.getString(1));;
            e.setName(rs.getString(2));
            e.setPrice(rs.getDouble(3));
            e.setDescription(rs.getString(4));
            e.setProducer(rs.getString(5));
            e.setStockQuantity(rs.getLong(6));
            e.setStockInOrder(rs.getLong(7));
            e.setActive(rs.getBoolean(8));
            
            list.add(e);
        }
        con.close();
    } catch (Exception e) {
    	System.out.println("PROBLEM WITH THE LIST");
        e.printStackTrace();
    }

    return list;
}

public static int save(Medicament medicament) {
    int status = 0;

    try {
        Connection connection = MedicamentDao.getConnection();
        PreparedStatement preparedStatment = connection
                .prepareStatement("insert into Medicament (medicamentId,name,price,description,producer,stockQuantity,stockInOrder,active) "
                					+ "values (?,?,?,?,?,?,?,?)");
        preparedStatment.setString(1, medicament.getMedicamentId());
        preparedStatment.setString(2, medicament.getName());
        preparedStatment.setDouble(3, medicament.getPrice());
        preparedStatment.setString(4, medicament.getDescription());
        preparedStatment.setString(5, medicament.getProducer());
        preparedStatment.setLong(6, medicament.getStockQuantity());
        preparedStatment.setLong(7, medicament.getStockQuantity());
        preparedStatment.setBoolean(8, medicament.getActive());
        

        status = preparedStatment.executeUpdate();

        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return status;
}

public static Medicament getMedicamentById(String idMedicament) {

    Medicament medicament = new Medicament();

    try {
        Connection connection = MedicamentDao.getConnection();
        PreparedStatement preparedStatment = connection
                .prepareStatement("select * from MEDICAMENT where MEDICAMENTID=?");
        preparedStatment.setString(1, idMedicament);

        ResultSet rs = preparedStatment.executeQuery();
        if (rs.next()) {
            medicament.setMedicamentId(rs.getString(1));
            medicament.setName(rs.getString(2));
            medicament.setPrice(rs.getDouble(3));
            medicament.setDescription(rs.getString(4));
            medicament.setProducer(rs.getString(5));
            medicament.setStockQuantity(rs.getInt(6));
            medicament.setStockInOrder(rs.getInt(7));
            medicament.setActive(rs.getBoolean(8));
        }
        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return medicament;
}

public static int update(Medicament medicament) {

    int status = 0;
    try {
        Connection connection = MedicamentDao.getConnection();
        PreparedStatement preparedStatment = connection
                .prepareStatement("update MEDICAMENT set name=?,price=?,description=?,producer=?,stockQuantity=?,stockInOrder=?,active=? where medicamentId=?");

        
        preparedStatment.setString(1, medicament.getName());
        preparedStatment.setDouble(2, medicament.getPrice());
        preparedStatment.setString(3, medicament.getDescription());
        preparedStatment.setString(4, medicament.getProducer());
        preparedStatment.setLong(5, medicament.getStockQuantity());
        preparedStatment.setLong(6, medicament.getStockInOrder());
        preparedStatment.setBoolean(7, medicament.getActive());
        preparedStatment.setString(8, medicament.getMedicamentId());
        
        

        status = preparedStatment.executeUpdate();

        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return status;
}

public static int delete(String id) {
    int status = 0;

    try {

        Connection connection = MedicamentDao.getConnection();
        PreparedStatement prepareStatment = connection.prepareStatement("delete from MEDICAMENT where medicamentId=?");

        prepareStatment.setString(1, id);
        status = prepareStatment.executeUpdate();

        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;
}

}
