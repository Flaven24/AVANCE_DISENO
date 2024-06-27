package pe.edu.calificame.servlet.university;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.University;
import pe.edu.calificame.service.RatingServiceImpl;
import pe.edu.calificame.service.UniversityServiceImpl;

/**
 * Servlet implementation class ServletPostNewRating
 */
@WebServlet("/rating/ServletPostNewRating")
public class ServletPostNewRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Inject
	RatingServiceImpl ratingServiceImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostNewRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comment=request.getParameter("comment");
		System.out.println("YEII "+comment);
		
		
		System.out.println(request.getParameter("clarity").getClass());
		System.out.println(request.getParameter("difficulty").getClass());
		
		
		String webpage=request.getParameter("clarity");
//		System.out.println(name);
//		System.out.println(webpage);
//		
//		University university= new University();
//		university.setCname(name);
//		university.setCwebpage(webpage);
//		university.setDregist(new Timestamp(new Date().getTime()));
		
//		universityServiceImpl.register(university);
		System.out.println("Universidad Registrada");
		request.getRequestDispatcher("/university/University.xhtml").forward(request, response);
	}

}
