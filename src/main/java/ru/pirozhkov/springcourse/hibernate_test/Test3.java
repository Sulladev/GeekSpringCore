package ru.pirozhkov.springcourse.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pirozhkov.springcourse.hibernate_test.entity.Employee;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> employees = session.createQuery("from Employee").getResultList();  //в скобках имя Класса

            List<Employee> employees = session.createQuery("from Employee " +
                            "where name = 'Nickolay' AND salary > 600")  //в скобках имя поля
                                        .getResultList();
            for (Employee e: employees) {
                System.out.println(e);
            }

            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
