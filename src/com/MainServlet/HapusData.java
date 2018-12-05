package com.MainServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Manipulasi.Manipulasi;

/**
 * Servlet implementation class HapusData
 */
@WebServlet("/HapusData")
public class HapusData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */

	public HapusData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author zulkarnaen
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int ID = Integer.parseInt(request.getParameter("ID"));

		// hapus data
		Manipulasi datamanipulasi = new Manipulasi();
		if (datamanipulasi.deleteData(ID)) {
			response.sendRedirect("index.jsp");
		} else {
			out.print("gagal Menghapus Data cek Function Hapus Data");
		}
	}

	/**
	 * @author zulkarnaen
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
