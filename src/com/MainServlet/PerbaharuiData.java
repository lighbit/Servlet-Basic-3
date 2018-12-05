package com.MainServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataPegawai.DataPegawai;
import com.Manipulasi.Manipulasi;

/**
 * @author zulkarnaen
 */

@WebServlet("/PerbaharuiData")
public class PerbaharuiData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */

	public PerbaharuiData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author zulkarnaen
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Manipulasi datamanipulasi = new Manipulasi();
		DataPegawai datapegawai = datamanipulasi.getDataPegawaiById(Integer.parseInt(request.getParameter("ID")));

		// send data to servlet
		request.setAttribute("ID", datapegawai.getID());
		request.setAttribute("Nama", datapegawai.getNama());
		request.setAttribute("Golongan", datapegawai.getGolongan());
		request.setAttribute("Gaji_Perbulan", datapegawai.getGaji_Perbulan());
		request.setAttribute("Tanggal_Masuk", datapegawai.getTanggal_Masuk());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatepage.jsp");
		rd.forward(request, response);

	}

	/**
	 * @author zulkarnaen
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		if (request.getParameter("batal") == null) {

			// Ambil data dari form
			DataPegawai datapegawai = new DataPegawai();
			datapegawai.setNama(request.getParameter("Nama"));
			datapegawai.setGolongan(request.getParameter("Golongan"));
			datapegawai.setGaji_Perbulan(Integer.parseInt(request.getParameter("Gaji_Perbulan")));
//			datapegawai.setTanggal_Masuk(Timestamp.valueOf(request.getParameter("Tanggal_Masuk")));
			datapegawai.setID(Integer.parseInt(request.getParameter("ID")));

			// simpan data
			Manipulasi datamanipulasi = new Manipulasi();

			if (datamanipulasi.updateData(datapegawai)) {
				response.sendRedirect("index.jsp");
			} else {
				out.print("kesalahan dalam simpan data!");
			}
		} else {
			response.sendRedirect("index.jsp");
		}

	}

}
