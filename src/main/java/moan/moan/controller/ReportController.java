/**
 * @author Ardila Oscar
 * @author Castellaños Isabel
 * @author Hurtado Henry
 */
package moan.moan.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import moan.moan.model.Report;
import moan.moan.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public Set<Report> getReports(@PathVariable("idUser") int idUser) {
        System.out.println("Traer los reportes de ----------------------------------------" + idUser);
        Set<Report> reportsUser = new HashSet<>();
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteriaUser = s.createCriteria(User.class);
        Criteria criteriaReport = s.createCriteria(Report.class);
        List users = criteriaUser.list();
        List reports = criteriaReport.list();
        Set<User> allUsers = new HashSet<>(users);
        Set<Report> allReports = new HashSet<>(reports);
        for (User t : allUsers) {
            if (t.getDocNumber() == idUser) {
                reportsUser = t.getMyReports();
            }
        }

        return reportsUser;
    }

    
    private SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
