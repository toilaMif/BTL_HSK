package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.ConnectDB;

public class testDB {
	public static void main(String[] args) {
		try {
		    ConnectDB.getInstance().connect();
		    Connection con = ConnectDB.getConnection();
		    String sql = "Select * from NhanVien";
		    Statement statement = con.createStatement();
		    ResultSet rs = statement.executeQuery(sql);
		    while (rs.next()) {
		        System.out.print(rs.getString(1) + "|");
		        System.out.print(rs.getString(2) + "|");
		        System.out.print(rs.getString(3) + "|");
		        System.out.println();
		        System.out.println("-------------------");
		    }
		    rs.close();
		    statement.close();
		    con.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	}
}
