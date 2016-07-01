// Hibernate Application Class
// Hibernate inserts a row into the HibernateInvest table and the HibernateDesc table

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

public class HibernateApp {
	public static void main(String[] args) {

		System.out.println("Hibernate many to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		HibernateInvest stock = new HibernateInvest();
		stock.setStockCode("7546");
		stock.setStockName("YHO");

		HibernateDesc category1 = new HibernateDesc("CONSUMER", "CONSUMER COMPANY");
		HibernateDesc category2 = new HibernateDesc("INVESTMENT", "INVESTMENT COMPANY");

		Set<HibernateDesc> categories = new HashSet<HibernateDesc>();
		categories.add(category1);
		categories.add(category2);

		stock.setCategories(categories);

		session.save(stock);

		session.getTransaction().commit(); // TCL COMMIT
		System.out.println("Done");
	}
}
