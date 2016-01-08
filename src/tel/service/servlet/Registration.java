package tel.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tel.data.model.DataConstant;
import tel.data.model.Doctor;
import tel.data.model.Patient;
import tel.data.model.User;
import tel.service.manager.DoctorManager;
import tel.service.manager.PatientManager;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/newUser")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("optionsRadios").equals(DataConstant.RADIO_VALUE_PATIENT_STRING))
		{
			Patient patient=new Patient(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("userName"),
					request.getParameter("userPassword"),DataConstant.USER_TYPE_PATIENT_INT, "Dhaka", 123);
			new PatientManager().addPatient(patient);
			
		}	
		else if(request.getParameter("optionsRadios").equals(DataConstant.RADIO_VALUE_DOCTOR_STRING))
		{
			Doctor doctor=new Doctor(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("userName"),
					request.getParameter("userPassword"),DataConstant.USER_TYPE_DOCTOT_INT,1,"Dhaka");
			new DoctorManager().addDoctor(doctor);
		}
		
		response.getWriter().write("Inserted Sucessfully");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
