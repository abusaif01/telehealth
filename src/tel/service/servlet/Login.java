package tel.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tel.data.model.DataConstant;
import tel.data.model.Doctor;
import tel.data.model.Message;
import tel.data.model.Patient;
import tel.data.model.User;
import tel.service.manager.DoctorManager;
import tel.service.manager.UserManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/logon")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession Usersession=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usersession=request.getSession(true);
		
		User user=new User(request.getParameter(DataConstant.USER_NAME_STRING),request.getParameter(DataConstant.USER_PASSWORD_STRING));
		user=new UserManager().logonUser(user);
		Doctor doctor;
		Patient patient;
	
		
		if(user!=null)
		{
			if(user.getUserType()==DataConstant.USER_TYPE_PATIENT_INT)
			{
				patient=(Patient)user;
				Usersession.setAttribute(DataConstant.SESSION_ID_PATIENT_STRING,patient);
				System.out.println(patient.getFirstName()+" "+patient.getLastName()+" "+patient.getAge());
				response.getWriter().write("1");
			
			}
		
			else if(user.getUserType()==DataConstant.USER_TYPE_DOCTOT_INT)
			{
				doctor=(Doctor)user;
				Usersession.setAttribute(DataConstant.SESSION_ID_DOCTOR_STRING,doctor);
				System.out.println(doctor.getFirstName()+" "+doctor.getLastName()+" "+doctor.getAvailability());
				response.getWriter().write("1");
			}
		}
		
		else response.getWriter().write("2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
