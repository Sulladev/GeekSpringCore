package ru.pirozhkov.springcourse.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pirozhkov.springcourse.hibernate_one_to_one.entity.Detail;
import ru.pirozhkov.springcourse.hibernate_one_to_one.entity.Employee;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                               .configure("hibernate.cfg.xml")
                               .addAnnotatedClass(Employee.class)
                               .addAnnotatedClass(Detail.class)
                               .buildSessionFactory();

        Session session = null;

        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Alex","Ovechkin","Sales", 700);
//            Detail detail = new Detail("Kazan", "728654627", "ao@yandex.ru");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//            //detail сохраняться благодаря cascade = CascadeType.ALL
//            session.save(employee);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class,1);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
