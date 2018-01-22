package com.company.hibernate.tryout.controller;

import com.company.hibernate.tryout.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import java.util.List;

public class UpdatingObjects {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        int studentId = 3;

        try{
            //session = factory.getCurrentSession();
            session.beginTransaction();

            Student stu = session.get(Student.class, studentId);
            stu.setEmail("--");

            session.getTransaction().commit();

        }finally{

            factory.close();
        }

    }

}
