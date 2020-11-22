package ru.pirozhkov.springcourse.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pirozhkov.springcourse.hibernate_many_to_many.entity.Child;
import ru.pirozhkov.springcourse.hibernate_many_to_many.entity.Section;

public class Test {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Section section = new Section("FPV");
//            Child child1 = new Child("Kenney", 5);
//            Child child2 = new Child("Eric", 6);
//            Child child3 = new Child("Stan", 5);
//            Child child4 = new Child("Kyle", 7);
//
//            section.addChildToSection(child1);
//            section.addChildToSection(child2);
//            section.addChildToSection(child3);
//            section.addChildToSection(child4);
//
//            session.beginTransaction();
//
//            session.save(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
         // ****************************************************************************************

//            session = factory.getCurrentSession();
//            Child child1 = new Child("Token", 8);
//            Section section1 = new Section("Football");
//            Section section2 = new Section("Ping-Pong");
//            Section section3 = new Section("Chess");
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild((section3));
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //********************************************************************

            session = factory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 5);
            System.out.println(child);
            
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
