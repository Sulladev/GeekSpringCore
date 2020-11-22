package ru.pirozhkov.springcourse.hibernate_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pirozhkov.springcourse.hibernate_one_to_many_bi.entity.Department;
import ru.pirozhkov.springcourse.hibernate_one_to_many_bi.entity.Employee;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                               .configure("hibernate.cfg.xml")
                               .addAnnotatedClass(Employee.class)
                               .addAnnotatedClass(Department.class)
                               .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Department department = new Department("IT", 300, 1500 );
//            Employee employee1 = new Employee("Ron", "Swonson", 800);
//            Employee employee2 = new Employee("Lesley", "Knope", 1000);
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//
//            session.beginTransaction();
//            session.save(department);  //при сохранении department employee также сохранятся
//            session.getTransaction().commit();
//            System.out.println("Done!");

//           *******************************************************************************************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmployees());
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            ********************************************************************************************

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class,1);
            session.delete(employee); // при Cascade удаление одного сотрудника потянет за собой удаление департамента
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
