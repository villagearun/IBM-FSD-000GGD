    
package comm.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.League;
@WebServlet("/add_league.do")
public class AddLeagueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String season,title,year;
	private int iYear;
    private List<String> errMsgs;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		errMsgs=new LinkedList<String>();
		season=request.getParameter("season");
		if(season.equals("Unknmown"))
		{
			errMsgs.add("please select a valid season.");
		}
		
		year=request.getParameter("year");
		try {
			iYear=Integer.parseInt(year);
			
		} catch (Exception e) {
			// TODO: handle exception
			errMsgs.add("year must be numeric");
		}
		
		
		title=request.getParameter("title");
		if(title.toString().length()<5)
		{
			errMsgs.add("title is too short.");
		}
		
		//if(errMsgs.isEmpty())
		//{
			request.setAttribute("SUCCESS", new League(title, iYear, season));
			request.setAttribute("ERROR", errMsgs);
			Connection connection=MyConnectionFactory.getMySqlConnectionForHR();
			PreparedStatement pst=connection.prepareStatement("insert into league(title,season,year,uid) values(?,?,?,?)");
			pst.setString(1, title);
			pst.setString(2, season);
			pst.setInt(3, iYear);
			pst.setInt(4, League.serialVersionUID++);
			pst.executeUpdate();
			RequestDispatcher  view=request.getRequestDispatcher("Soccer.jsp");
			view.forward(request, response);
		//}
		//else {
			
			//RequestDispatcher view=request.getRequestDispatcher("error.view");
			//view.forward(request, response);
		//}
		
	}


}
                                            