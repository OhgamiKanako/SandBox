package jp.ac.o_hara.site.blog;

import java.io.Serializable;
import java.sql.Date;

public class BlogBean implements Serializable {
	private String userId = null;
	private Date date = null;
	private String title = null;
	private String article = null;
	
	public BlogBean() {}
	public BlogBean(String userId, Date date, String title, String article) {
		
	}
	
	public void setUserId(String id){this.userId = id;}
	public String getUserId() {return this.userId;}
	public void setDate(Date date) {this.date = date;}
	public Date getDate() {return this.date;}
	public void setTitle(String title) {this.title = title;}
	public String getTitle() {return this.title;}
	public void setArticle(String article) {this.article = article;}
	public String getArticle() {return this.article;}
}

