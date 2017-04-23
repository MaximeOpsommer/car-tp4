package car.tp4.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.tp4.entity.PanierBean;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet{
	
	@EJB
	private PanierBean panierBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("panier", panierBean.getPanier());
		System.out.println("Hello, i'm in panier servlet, here is the panier : ");
		System.out.println(panierBean.getPanier());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/panier.jsp");
		dispatcher.forward(request, response);
	}

}
