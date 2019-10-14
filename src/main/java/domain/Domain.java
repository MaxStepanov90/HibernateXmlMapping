package domain;

import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.*;

public class Domain {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham");
        address.setStreet("Arkham street 1");
        address.setPostCode("0987");

        Employee employee = new Employee();
        employee.setFirstname("John");
        employee.setLastname("Gordon");

        Calendar calendar = new GregorianCalendar();
        calendar.set(1939,Calendar.MAY,1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("5678");

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
