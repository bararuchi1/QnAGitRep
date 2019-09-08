package com.pkd.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.pkd.bean.QnAPatternBean;
import com.pkd.bean.Test;
import com.pkd.helper.MakeQuestionPatternHelper;

@Path("/QnAFirstController")

public class QnAFirstController {
	private final static Logger LOGGER = Logger.getLogger(QnAFirstController.class.getName());

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insertQnAPatteren(InputStream input) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		MakeQuestionPatternHelper qHelper = new MakeQuestionPatternHelper();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
		Map<String, String> newMap = null;
		newMap = qHelper.saveQpatteren(crunchifyBuilder);

		// Map<String, String> newMap = new HashMap<>();
		// newMap.put("Name", "Bararuchi");
		/*
		 * String output = "{'Name':'Bararuchi','Port':'8080'}"; String>
		 * newMap=new HashMap<>(); newMap.put("Name", "Bararuchi");
		 * newMap.put("Port","8088"); LOGGER.info(input.toString());
		 */
		return Response.ok(newMap).build();
	}

}
