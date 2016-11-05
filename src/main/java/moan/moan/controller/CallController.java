/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moan.moan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import moan.moan.model.Call;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author castellanosisa
 */

@RestController
@RequestMapping(value = "/calls")
public class CallController {
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<Call> getCalls() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Call.class);
        List calls = criteria.list();
        Set<Call> allCalls = new HashSet<>(calls);
        System.out.println("Llamadas---->" + allCalls.toString());
        return allCalls;

    }

    private SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

}
