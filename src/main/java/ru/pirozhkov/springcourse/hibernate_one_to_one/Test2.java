package ru.pirozhkov.springcourse.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pirozhkov.springcourse.hibernate_one_to_one.entity.Detail;
import ru.pirozhkov.springcourse.hibernate_one_to_one.entity.Employee;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                               .configure("hibernate.cfg.xml")
                               .addAnnotatedClass(Employee.class)
                               .addAnnotatedClass(Detail.class)
                               .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Artem","Panarin","HR", 1000);
//            Detail detail = new Detail("NY", "34569897", "ap@yahoo.com");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//            session.save(detail);
//            session.getTransaction().commit();
//            System.out.println("Done!");


            session = factory.getCurrentSession();

            session.beginTransaction();
            Detail detail = session.get(Detail.class,1);
            System.out.println(detail.getEmployee());
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
