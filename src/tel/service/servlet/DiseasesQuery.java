package tel.service.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.String;

import tel.data.model.tree.TreatmentDecisionTree;
import tel.data.model.tree.Medicine;

/**
 * Servlet implementation class DiseasesQuery
 */
@WebServlet("/DiseasesQuery")
public class DiseasesQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiseasesQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("diseaseId"));
		response.getWriter().write(TreatmentDecisionTree.getTreatmentDecisionTree().getResponse(Integer.parseInt(request.getParameter("diseaseId"))-1));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count=TreatmentDecisionTree.getTreatmentDecisionTree().childCount;
		Vector<Medicine> medList;
		String[] parameterNames=new String[count];
		int[] values=new int[count];
		// System.out.println("parameters kk"+request.getParameter("info"+1));
		// System.out.println("ccc "+TreatmentDecisionTree.getTreatmentDecisionTree().childCount);

	
		for(int i=0;i<count;i++ )
		{
			values[i]=Integer.parseInt(request.getParameter("info"+(i+1)));
			System.out.println("parameters "+values[i]);
		  
		}
		medList=TreatmentDecisionTree.getTreatmentDecisionTree().getTreatment( values);
		request.setAttribute("medicines", medList);
		RequestDispatcher rdp=request.getRequestDispatcher("prescription.jsp");
		rdp.forward(request, response);
		
	}

}
