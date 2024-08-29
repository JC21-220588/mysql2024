package jp.ac.jc21;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/item")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final String dbServer = "192.168.54.231";
	final String dbPort = "3306";
	final String dbName = "test2023";
	final String user = "test2023";
	final String pass = "test2023";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "jdbc:mysql://" + dbServer + "/" + dbName;
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("aa");
		response.getWriter().append("<h2>Connect to : ").append(url).append("</h2>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);

			//String sql = "SELECT MAKER_CODE,MAKER_NAME FROM MAKER";
			String sql2 =  "SELECT PRODUCT_CODE,PRODUCT_NAME,MAKER_CODE FROM PRODUCT WHERE MAKER_CODE = ?";
			
			//PreparedStatement statement = conn.prepareStatement(sql);
			PreparedStatement statement2 = conn.prepareStatement(sql2);

			String id = request.getParameter("ID");
			statement2.setString(1, id);

			//ResultSet rs = statement.executeQuery();
			ResultSet rs2 = statement2.executeQuery();

			//ArrayList<String[]> item = new ArrayList<>();
			ArrayList<String[]> item2 = new ArrayList<>();

			//while (rs.next() == true) {
				//String[] s = new String[2];
				//s[0] = rs.getString("MAKER_CODE");
				//s[1] = rs.getString("MAKER_NAME");
				//item.add(s);
			//}
			
			while (rs2.next() == true) {
				String[] s = new String[3];
				s[0] = rs2.getString("PRODUCT_CODE");
				s[1] = rs2.getString("PRODUCT_NAME");
				s[2] = rs2.getString("MAKER_CODE");
				item2.add(s);
			}
			
			
			//request.setAttribute("item", item);
			request.setAttribute("item2", item2);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

