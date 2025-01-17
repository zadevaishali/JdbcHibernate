package org.primepro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/init") // read request coming from html
public class InitializeHibernateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		// call hibernate session factory
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.openSession();

		out.println("Session is  Opened");

		session.close();

		out.println("session is closed");

//		Transaction tx = session.beginTransaction();
//
//		Student s1 = new Student("Vaishali", "zadevaishali09@gmail.com", "1234");
//		session.save(s1);
//		tx.commit();
//		session.close();
//		out.println("Data inserted succesfully");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
