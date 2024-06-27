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

import model.Professor;
import pe.edu.calificame.controller.ControllerDetailUniversity;
import pe.edu.calificame.service.UniversityServiceImpl;

/**
 * Servlet implementation class ServletPostNewProfessor
 */
@WebServlet("/professor/ServletPostNewProfessor")
public class ServletPostNewProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	ControllerDetailUniversity controllerDetailUniversity;
	@Inject
	UniversityServiceImpl universityServiceImpl;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostNewProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String lastname=request.getParameter("lastname");
		
		Professor professor = new Professor();
		professor.setCname(name);
		professor.setClastname(lastname);
		professor.setBactive(true);		
		professor.setDregist(new Timestamp(new Date().getTime()));
		universityServiceImpl.registerProfessor(professor,controllerDetailUniversity.getUniversity());
		
		System.out.println("Profesor Registrado");
		request.getRequestDispatcher("/university/DetailUniversity.xhtml").forward(request, response);
	}

}
