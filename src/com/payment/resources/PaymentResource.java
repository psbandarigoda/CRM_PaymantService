package com.payment.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.payment.model.Payment;
import com.payment.service.PaymentService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/payment")
public class PaymentResource {

	PaymentService paymentService = new PaymentService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Doctor> getDoctors() {
//		return userService.getAlldoctors();
//	}
	
	@POST
	@Path("/addPayment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("method") String method,
							 @FormParam("amount") String amount,
							 @FormParam("cardNo") String cardNo,
							 @FormParam("date") String date) {
		String output = paymentService.insertPayment(method, amount, cardNo, date);
		return output;
	}
	
	@GET
	@Path("/getAllPayment")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return paymentService.readPayment();
	}

	@PUT
	@Path("/updatePayment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject doctorObject = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object
		String ID = doctorObject.get("ID").getAsString();
		// String password = doctorObject.get("password").getAsString();
		String cardNo = doctorObject.get("contactNo").getAsString();
		
		String output = paymentService.updatePayment(ID, cardNo);
		return output;
	}
	
	
	
	@DELETE
	@Path("/deletePaymentByID/{id}")
	public String deleteDoctor(@PathParam("id") String id) {
		String output = paymentService.deletePayment(id);
		return output;
	}
	
	
	// Get Appointment By Id
	@GET
	@Path("/getPaymentById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPaymentById(@PathParam("id")String id) {
		Payment payment = paymentService.getPaymentById(id);
		return payment;
	}
}
