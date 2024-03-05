package nastya.ru;

import nastya.ru.model.Principal;
import nastya.ru.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Principal principal = new Principal("Anastasiia", 23);
            School school = new School(58);

            principal.setSchool(school);

            session.persist(principal);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}

