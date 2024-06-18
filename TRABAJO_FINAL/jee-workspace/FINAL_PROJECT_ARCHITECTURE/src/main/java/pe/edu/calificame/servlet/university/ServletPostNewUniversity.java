package pe.edu.calificame.servlet.university;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.University;
import pe.edu.calificame.service.UniversityServiceImpl;

/**
 * Servlet implementation class ServletPostNewUniversity
 */
@WebServlet("/university/ServletPostNewUniversity")
public class ServletPostNewUniversity extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Inject
	UniversityServiceImpl universityServiceImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPostNewUniversity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String webpage=request.getParameter("webpage");
		System.out.println(name);
		System.out.println(webpage);
		
		University university= new University();
		university.setCname(name);
		university.setCwebpage(webpage);
		
		universityServiceImpl.register(university);
		System.out.println("Universidad Registrada");
//		request.getRequestDispatcher("/ServletGetEstudiantes").forward(request, response);
	}

}
