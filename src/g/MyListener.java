package g;

import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener {

	//https://www.javatpoint.com/src/projects/projecteclipse/onlinebanking.zip

	
	public void contextInitialized(ServletContextEvent arg0) {
		boolean status = false;
		Connection con = null;

		try {
			con = GetCon.getCon();
			PreparedStatement ps1 = con.prepareStatement("Select * from NEWACCOUNT");

			try {
				status = ps1.execute();
			}

			catch (Exception e) {
				System.out.println("Error while checking for table ");
				e.printStackTrace();
			}

			if (status) {
				System.out.println("your table name already exist" + status);
			}else {
				System.out.println("table is not defined. Please create table. Refer db table.txt in this project source code. " + status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");

	}
}
