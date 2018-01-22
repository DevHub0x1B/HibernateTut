package com.company.hibernate.tryout.controller;

import com.company.hibernate.tryout.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryObjects {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();


        try{

            session.beginTransaction();

            List<Student> allStudents = session.createQuery("from Student s where s.lastName LIKE '%ns'").getResultList();

            for(Student s : allStudents){
                System.out.println(s);
            }


            session.getTransaction().commit();

        }finally{


        }


    }

}
