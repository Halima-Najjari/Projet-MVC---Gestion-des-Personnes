package Controlleur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connextionDB.ConnextionDatabase;
import models.Personne;
import models.Metier.PeronneMetier;

/**
 * Servlet implementation class PersonneControler
 */
@WebServlet("/PersonneControler")
public class PersonneControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonneControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn = ConnextionDatabase.getConnextion();
		try {
			
			Statement st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("St ok");
		PeronneMetier e = new PeronneMetier();
		String id = request.getParameter("id");
		if(id != null) {
			e.supprimerPersonne(Integer.parseInt(id));
			response.sendRedirect("PersonneControler");
		}else {
			request.setAttribute("ListPersonnes", PeronneMetier.ListPersonnes());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListPersonnes.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));
		PeronneMetier e = new PeronneMetier();
		e.ajouterPersonne(new Personne(name, prenom, age));
		response.sendRedirect("PersonneControler");
	}

}
