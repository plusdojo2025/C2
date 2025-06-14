package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblRegistuserDao;
import dto.TblRegistuserDto;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblRegistuserDao tblRegistuserDao = new TblRegistuserDao();
		TblRegistuserDto tblRegistuserDto = new TblRegistuserDto();
		
		tblRegistuserDto.setMail("mail");
		tblRegistuserDto.setPassword("password");
		tblRegistuserDto.setName("name");
		tblRegistuserDto.setFamilyId("familyId");
		
		//tblRegistuserDto.setUserNumber(23);
		
		tblRegistuserDao.insert(tblRegistuserDto);
		tblRegistuserDao.select(tblRegistuserDto);
		tblRegistuserDao.update(tblRegistuserDto);
		tblRegistuserDao.delete(tblRegistuserDto);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
