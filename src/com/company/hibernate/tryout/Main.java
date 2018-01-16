package com.company.hibernate.tryout;

import com.company.hibernate.tryout.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Student tempStudent = new Student("moe", "money", "moe@gmail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();

            System.out.println("Student registered!");


        } finally { //no catch ?!
            factory.close();
        }


    }
}
