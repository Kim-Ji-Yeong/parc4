package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class ModServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int iboard2 = Integer.parseInt(iboard);
		BoardVO data = BoardDAO.selBoard(iboard2);
		request.setAttribute("data", data);
		
		
		
		
		String jsp = "/WEB-INF/view/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String iboard = request.getParameter("iboard");
		int iboard2 = Integer.parseInt(iboard);
		
		BoardVO a = new BoardVO();
		a.setCtnt(ctnt);
		a.setTitle(title);
		a.setIboard(iboard2);
		BoardDAO.updBoard(a);
		response.sendRedirect("/list");
	}

}
