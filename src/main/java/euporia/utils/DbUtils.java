package euporia.utils;

import euporia.database.catalogues.Catalogue;
import euporia.database.catalogues.CatalogueObject;
import euporia.database.usermanagement.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * TODO check whether it's best to keep a single session opened
 * or rather open a new one everytime
 */
public class DbUtils {
    private static DbUtils instance;
    private SessionFactory sessionFactory;

    private DbUtils(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void finalize() {
        if (sessionFactory.isOpen())
            sessionFactory.close();
    }

    public static DbUtils getInstance() {
        if (DbUtils.instance == null) {
            final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Catalogue.class);
            sources.addAnnotatedClass(CatalogueObject.class);
            sources.addAnnotatedClass(User.class);
            instance = new DbUtils(sources.buildMetadata().getSessionFactoryBuilder().build());
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
