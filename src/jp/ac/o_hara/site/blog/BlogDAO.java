package jp.ac.o_hara.site.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.ac.o_hara.site.SimpleDAO;

public class BlogDAO extends SimpleDAO {
	private static BlogDAO dao = new BlogDAO();
	
	private BlogDAO() {
	}//privateにすすことで、外部からアクセスできなくなる
	
	public static BlogDAO getInstance() {//staticメソッドでインスタンス化する
		return dao;
	}
	

public boolean create(BlogBean blog) {
	Connection db = this.createConnection();
	//PreparedStatement ps = null;
	boolean result = false;
	try (PreparedStatement ps = db.prepareStatement("INSERT INTO usertbl(userID, date, title, article) VALUES(?, ?, ?, ?)")) {
		//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
		ps.setString(1, blog.getUserId());
		ps.setDate(2, blog.getDate());
		ps.setString(3, blog.getTitle());
		ps.setString(4, blog.getArticle());
		ps.executeUpdate();
		result = true;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		this.closeConnection(db);
	}
	return result;
}

}

