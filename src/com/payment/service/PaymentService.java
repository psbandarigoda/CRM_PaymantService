package com.payment.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.payment.database.DBConnection;
import com.payment.model.Payment;


public class PaymentService {
		
	
	public String insertPayment(String method, String amount, String cardNo, String date) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// create a prepared statement
			String query = " insert into payment (`id`,`method`,`amount`,`cardNo`,`date`)"
					+ " values (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, method);
			preparedStmt.setString(3, amount);
			preparedStmt.setString(4, cardNo);
			preparedStmt.setString(5, date);
			

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String readPayment() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>ID</th><th>method</th><th>amount</th><th>cardNo</th><th>date"
					+ "</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String ID = Integer.toString(rs.getInt("id"));
				String method = rs.getString("method");
				String amount = rs.getString("amount");
				String cardNo = rs.getString("cardNo");
				String date = rs.getString("date");
				
				
				// Add into the html table
				output += "<tr><td>" + ID + "</td>";
				output += "<td>" + method + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + cardNo + "</td>";
				output += "<td>" + date + "</td>";
				
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\""
						+ " value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"doctor.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"" + " class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + ID + "\">" + "</form></td></tr>";
			}
			con.close();
			
			
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updatePayment(String ID, String cardNo) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			
			// create a prepared statement
			String query = "UPDATE doctor SET cardNo=? " 
			+ "WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			// preparedStmt.setString(1, cardNo);
			preparedStmt.setString(1, cardNo);
			preparedStmt.setInt(2, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String deletePayment(String ID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			
			// create a prepared statement
			String query = "delete from payment "
					+ "where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	// Get Customer data by ID
	public Payment getPaymentById(String aId) {

		Payment payment = new Payment();

		try {
			Connection con = DBConnection.connect();

			String query = "select * from payment where id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(aId));

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				payment.setId(aId);
				payment.setCardNo("cardNo");
				payment.setDate("date");
				payment.setAmount("amount");
				payment.setMethod("method");
				
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return payment;
	}
}
