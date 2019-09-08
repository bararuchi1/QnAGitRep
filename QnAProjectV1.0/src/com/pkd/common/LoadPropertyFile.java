package com.pkd.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.pkd.controller.QnAFirstController;

@WebServlet(urlPatterns = "/LoadPropertyFile", loadOnStartup = 1, asyncSupported = true)
public class LoadPropertyFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(LoadPropertyFile.class.getName());

	public LoadPropertyFile() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			InputStream is = new FileInputStream("C:\\propFilesconfig\\MongoDbConnectionDetails.properties");
			Properties pro = new Properties();
			pro.load(is);
			LOGGER.info("--------Reading Common Param------");

			System.setProperty("DBCONNECTSTRING", pro.getProperty("DBCONNECTSTRING"));
			System.setProperty("DATABASENAME", pro.getProperty("DATABASENAME"));
			LOGGER.info("Common property : DBCONNECTSTRING------" + System.getProperty("DBCONNECTSTRING"));
			LOGGER.info("Common property : DATABASENAME------" + System.getProperty("DATABASENAME"));
			
			LOGGER.info("--------Reading Common Param Completed------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Property File Not Found");

		}
	}

}
