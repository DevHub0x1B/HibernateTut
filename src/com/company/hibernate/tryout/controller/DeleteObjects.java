package com.company.hibernate.tryout.controller;

import com.company.hibernate.tryout.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class DeleteObjects {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session  = factory.getCurrentSession();

        try{
            int studentId = 1;
            session.beginTransaction();

            Student stu = session.get(Student.class, studentId);
            session.delete(stu);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }




    }

}
