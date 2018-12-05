<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Update</title>
</head>
<body>
	<h1><font size="7" face="Georgia, Arial" color="maroon">U</font>pdate <font size="7" face="Georgia, Arial" color="maroon">S</font>ection</h1>
	<hr/>
	<form action="PerbaharuiData" method="POST">
	<tr>
		<td><input type="hidden" value="${ID}" name="ID"></td>
		<td><code>Nama karyawan : </code></td>
		<td><input type="text" name="Nama" value="${Nama}"> |</td>
		
		<td><code>Golongan :</code></td>
		<td><input type="text" name="Golongan" value="${Golongan}"> |</td> 
		
		<td><code>Gaji Perbulan :</code></td>
		<td><input type="text" name="Gaji_Perbulan" value="${Gaji_Perbulan}"> |</td>
		
		<td><input type="hidden" value="${Tanggal_Masuk}" name="Tanggal_Masuk"></td>
		
		<td><input type="submit" name="kirim" value="kirim"></td>
		<td><input type="submit" name="batal" value="batal"></td>
	</tr>
	</form>

</body>
</html>