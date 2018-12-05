package com.Manipulasi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DataPegawai.DataPegawai;
import com.Koneksi.Koneksi;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Manipulasi {
	
//	Timestamp  tanggal_masuk = new Timestamp(new java.util.Date().getTime());
	
	private Connection conn = null;

	public Manipulasi() {
		
		// Memanggil Koneksi sebagai variable conn
		conn = new Koneksi().getKoneksi();
	}

// ==============================================================================================================================================

// Membuat Fungsi InsertData ke Database
	public boolean insertData(DataPegawai insertdata) {
		Boolean insert = false;
		
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("E yyyy.MM.dd 'jam' hh:mm:ss a 'WIB'");
		String dates = date.format(today);

		try {
			// Mengisi Query
			String query = "INSERT INTO Karyawan (ID,Nama,Golongan,Gaji_Perbulan,Tanggal_Masuk) VALUES (NULL,?,?,?,?)";
			// Mempersiapkan Statement
			PreparedStatement preparedstatement = (PreparedStatement) conn.prepareStatement(query);
			preparedstatement.setString(1, insertdata.getNama());
			preparedstatement.setString(2, insertdata.getGolongan());
			preparedstatement.setInt(3, insertdata.getGaji_Perbulan());
			preparedstatement.setString(4, dates);
			

			// eksekusi prepare statment
			preparedstatement.execute();
			insert = true;
			conn.close();

		} catch (SQLException e) {
			System.out.print("Ada yang salah Dalam Fungsi InsertData");
			e.printStackTrace();
		}

		return insert;
	}

// ==============================================================================================================================================

// Membuat Fungsi untuk List Data pada Data Pegawai
	public List<DataPegawai> getDataPegawai() {
		List<DataPegawai> listDataPegawai = new ArrayList<DataPegawai>();

		try {
			String query = "SELECT ID,Nama,Golongan,Gaji_Perbulan,Tanggal_Masuk FROM Karyawan";
			Statement statement = (Statement) conn.createStatement();
			ResultSet resultset = statement.executeQuery(query);

			while (resultset.next()) {
				DataPegawai datapegawai = new DataPegawai();
				datapegawai.setID(resultset.getInt("ID"));
				datapegawai.setNama(resultset.getString("Nama"));
				datapegawai.setGolongan(resultset.getString("Golongan"));
				datapegawai.setGaji_Perbulan(resultset.getInt("Gaji_Perbulan"));
				datapegawai.setTanggal_Masuk(resultset.getString("Tanggal_Masuk"));
				listDataPegawai.add(datapegawai);
			}
			conn.close();
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listDataPegawai;
	}

// ==============================================================================================================================================

// Membuat Fungsi memunculkan DataPegawai di index.jsp
	public DataPegawai getDataPegawaiById(int ID) {
		DataPegawai datapegawai = new DataPegawai();

		try {
			String query = "SELECT ID,Nama,Golongan,Gaji_Perbulan,Tanggal_Masuk FROM Karyawan WHERE ID=" + ID;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				datapegawai.setID(rs.getInt("ID"));
				datapegawai.setNama(rs.getString("Nama"));
				datapegawai.setGolongan(rs.getString("Golongan"));
				datapegawai.setGaji_Perbulan(rs.getInt("Gaji_Perbulan"));
				datapegawai.setTanggal_Masuk(rs.getString("Tanggal_Masuk"));
			} else {
				System.out.println("data Karyawan Tidak di Isi...");
			}

			conn.close();
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datapegawai;
	}

// ==============================================================================================================================================

	// Membuat Fungsi Menghapus Data
	public boolean deleteData(int ID) {
		Boolean booleans = false;

		try {
			// Mengisi Query
			String query = "DELETE FROM Karyawan WHERE ID=?;";
			// prepare Statment
			PreparedStatement preparedstatement = (PreparedStatement) conn.prepareStatement(query);
			preparedstatement.setInt(1, ID);

			// eksekusi prepare statment
			preparedstatement.execute();
			booleans = true;
			conn.close();

		} catch (SQLException e) {
			System.out.print("Ada yang salah Dalam Fungsi DeleteData");
			e.printStackTrace();
		}

		return booleans;
	}

// ==============================================================================================================================================

	// Membuat Fungsi Update Data
	public boolean updateData(DataPegawai updatedatapegawai) {
		Boolean booleans = false;
		
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("E yyyy.MM.dd 'jam' hh:mm:ss a 'WIB'");
		String dates = date.format(today);

		try {
			// Mengisi Query
			String query = "UPDATE `Karyawan` SET `Nama`=?, `Golongan`=?, `Gaji_Perbulan`=?, `Tanggal_Masuk`=? WHERE `ID`=?";
			// prepare Statment
			PreparedStatement preparedstatement = (PreparedStatement) conn.prepareStatement(query);
			preparedstatement.setString(1, updatedatapegawai.getNama());
			preparedstatement.setString(2, updatedatapegawai.getGolongan());
			preparedstatement.setInt(3, updatedatapegawai.getGaji_Perbulan());
			preparedstatement.setString(4, dates);
			preparedstatement.setInt(5, updatedatapegawai.getID());

			// eksekusi prepare statment
			preparedstatement.execute();
			booleans = true;
			conn.close();	

		} catch (SQLException e) {
			System.out.print("Ada yang salah Dalam Fungsi Mengupdate Data");
			e.printStackTrace();
		}

		return booleans;
	}

// ==============================================================================================================================================

	public static void main(String[] args) {
	}

}
