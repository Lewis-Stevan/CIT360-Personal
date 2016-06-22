import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageEmployee ME = new ManageEmployee();

		/* Added a few employee records into the database */
		Integer empID1 = ME.addEmployee("John", "Ali", 1000);
		Integer empID2 = ME.addEmployee("Daisy", "Duke", 5000);
		Integer empID3 = ME.addEmployee("John", "Micheal", 10000);

		/* List all the employees */
		ME.listEmployees();

		/* Update employee's records */
		ME.updateEmployee(empID1, 5000);

		/* Delete an employee from database */
		ME.deleteEmployee(empID2);

		/* List of leftover employees */
		ME.listEmployees();
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,
					EmployeeID);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,
					EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
