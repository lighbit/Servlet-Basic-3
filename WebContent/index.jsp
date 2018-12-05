<%@page import="java.sql.Timestamp"%>
<%@page import="com.sun.corba.se.spi.orbutil.fsm.Guard.Result"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.Manipulasi.Manipulasi"%>
<%@page import="com.DataPegawai.DataPegawai"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selamat Datang</title>
</head>
	
<body>
	<center><h1><font size="7" face="Georgia, Arial" color="maroon">M</font>asukan <font size="7" face="Georgia, Arial" color="maroon">D</font>ata</h1></center>
	<hr/>
	<form action="SimpanData" method="POST">
	<center><tr>
		<td><code> Nama Karyawan</code> </td>
		<td><input type="text" name="Nama"> |</td>

		<td><code> Golongan</code></td>
		<td><input type="text" name="Golongan"> |</td>
	
		<td><code> Gaji Perbulan</code></td>
		<td><input type="text" name="Gaji Perbulan"> |</td>
		
		<td><input	type="submit" value="kirim"></td>
	</tr></center>
	</form>
	
	<br>

	<center><table border="1" cellpadding="10" cellspacing="1">
		<thead>
			<tr>
				<th>Nama karyawan</th>
				<th>Golongan</th>
				<th>Gaji Perbulan</th>
				<th>Tanggal Masuk</th>
				<th>Option Section</th>
			</tr>
		</thead>

		<tbody>
			<%
				List<DataPegawai> users = new ArrayList<DataPegawai>();
				users = new Manipulasi().getDataPegawai();
				
				out.print("<h1><font size='7' face='Georgia, Arial' color='maroon'>T</font>able <font size='7' face='Georgia, Arial' color='maroon'>D</font>ata</h1><hr/></center>");
				out.print("<br>");
				for (DataPegawai user : users) {
					out.print("<center><tr>");
					out.print("<td>" + user.getNama() + "</td><td>" + user.getGolongan() + "</td><td>"
							+ "Rp. " + user.getGaji_Perbulan() + "</td><td>" + user.getTanggal_Masuk() + "</td>");
					out.print("<td><a href='PerbaharuiData?ID=" + user.getID() + "'>edit</a> | | ");
					out.print("<a href='HapusData?ID=" + user.getID() + "'>delete</a></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table></center>

</body>
</html>