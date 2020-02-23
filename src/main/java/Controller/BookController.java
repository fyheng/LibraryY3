package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import Domain.BookDomain;
import Domain.SupplierDomain;
import Enumeration.BooKStatus;
import configDB.JDBC;
import vathanak.Application;

public class BookController {

	public void create(String bookCode, String title, String language, String authors, String publicAt, String edition,
			int categoryId) {
		Connection con = Application.getConnection();
		BookDomain book = new BookDomain();
//    	 BooKStatus[] status = BooKStatus.values();
		book.setStatus(BooKStatus.NEW);
		try {
			String sql = "insert into book(book_code,title,language,status,authors,public_at,edition,category_id) "
					+ "values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bookCode);
			ps.setString(2, title);
			ps.setString(3, language);
			ps.setString(4, book.getStatus().toString());
			ps.setString(5, authors);
			ps.setString(6, publicAt);
			ps.setString(7, edition);
			ps.setInt(8, categoryId);
			ps.execute();
			con.close();
			Logger logger = Logger.getGlobal();
			logger.info("Insert Data Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
