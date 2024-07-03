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

import model.Rating;
import model.University;
import pe.edu.calificame.controller.ControllerRating;
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
	@Inject
	ControllerRating controllerRating;
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
		controllerRating.getRating().setDregist(new Timestamp(new Date().getTime()));
		ratingServiceImpl.register(controllerRating.getRating().Clone());
		request.getRequestDispatcher("/professor/DetailProfessor.xhtml").forward(request, response);
	}

}
