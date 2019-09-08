package com.pkd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pkd.bean.QnAPatterenReturnStatus;

@Path("/book")
public class CheckValue {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public Response addition(@PathParam("name") String name, @Context HttpHeaders header,
			@Context HttpServletResponse response) {
		List<String> list = new ArrayList<String>();
		Map<String, String> map = new HashMap<>();

		JsonParser parser = new JsonParser();
		QnAPatterenReturnStatus qnAPatterenReturnStatus = new QnAPatterenReturnStatus();
		response.setHeader("Access-Control-Allow-Origin", "*");
		// response.setHeader("Access-Control-Allow-Headers", "Cache-Control,
		// Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		// response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST");

		System.out.println("Hey " + name);
		String output = "";
		if (name.equalsIgnoreCase("PHP")) {
			map.put("Name", "Bararuchi");
		} // good</hello>";
		else
			output = "{'Name':'Pep'}";// "<?xml version='1.0'?>" + "<hello>" +
										// name + " is not good.</hello>";
		// JsonObject json = (JsonObject) parser.parse(output);
		System.out.println("----" + output);
		return Response.ok(map).build();
	}

}
