package com.company.hibernate.tryout.controller;

import com.company.hibernate.tryout.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            System.out.println("Adding 3 new students into school..");

            Student student1 = new Student("paul", "wall", "p.wall@gmail.com");
            Student student2 = new Student("david", "owns", "d.owns@gmail.com");
            Student student3 = new Student("dangerous", "jam", "d.jam@gmail.com");

            // Step 1: Start a transaction
            session.beginTransaction();

            // Step 2: Process needed data
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // Step 3: Commit the transaction
            session.getTransaction().commit();

            // Find sutdent's id
            System.out.println("Saved student. Generated id: " + student1.getId());
            System.out.println("Saved student. Generated id: " + student2.getId());
            System.out.println("Saved student. Generated id: " + student3.getId());

            // Begin a new transaction with the current session
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Read student's id
            Student s1 = session.get(Student.class, student1.getId());
            System.out.println("\nGetting student with id: " + s1);

            Student s2 = session.get(Student.class, student2.getId());
            System.out.println("\nGetting student with id: " + s2);

            Student s3 = session.get(Student.class, student3.getId());
            System.out.println("\nGetting student with id: " + s3);

            session.getTransaction().commit();

            System.out.println("Students are registered!");


        } finally { //no catch ?!
            factory.close();
        }




    }

}
