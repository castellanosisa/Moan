/**
 * @author Ardila Oscar
 * @author Castellaños Isabel
 * @author Hurtado Henry
 */
package moan.moan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import moan.moan.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public Set<User> getUsers() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(User.class);
        List users = criteria.list();
        Set<User> allUsers = new HashSet<>(users);
        System.out.println("Usuarios---->" + allUsers.toString());
        return allUsers;

    }

    private SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

}
