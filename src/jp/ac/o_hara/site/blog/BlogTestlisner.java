package jp.ac.o_hara.site.blog;

import java.sql.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class BlogTestlisner
 *
 */
@WebListener
public class BlogTestlisner implements ServletContextListener {
	BlogDAO dao = null;
    /**
     * Default constructor. 
     */
    public BlogTestlisner() {
       dao = BlogDAO.getInstance();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         if(System.getenv("DATABESE_URL")!= null) {
         }else {
        	 if(dao.execSQL("DELETE TABLE IF NOT EXISTS blogtbl"
        		+ "(id IDENTITY, userID VARCHAR(64), date DATE, title VARCHAR(64), article VARCHAR(64)")) {
        		 System.out.println("TestBlogDB is READY");
        	 }else {
        		 System.out.println("TestBlogDB is NOT READY");
        	 }
         }
         dao.create(new BlogBean("hoge", Date.valueOf("2020-10-08"),"ほげ","ほげほげ"));
         dao.create(new BlogBean("piyo", Date.valueOf("2020-10-08"),"ぴよ","ぴよぴよ"));
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
         dao = null;
    }
	
}
