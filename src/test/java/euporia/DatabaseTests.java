package euporia;

import euporia.database.catalogues.Catalogue;
import euporia.database.catalogues.CatalogueObject;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class DatabaseTests extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Catalogue.class);
            sources.addAnnotatedClass(CatalogueObject.class);
            sessionFactory = sources.buildMetadata().getSessionFactoryBuilder().build();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public void testSavingRetrieving() {
        CatalogueObject obj = new CatalogueObject("testObj");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(obj);
        session.save(new Catalogue(obj, "testObj", "Test"));
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Catalogue").list();
        for ( Catalogue catalogue : (List<Catalogue>) result) {
            System.out.println("Catalogue #" + catalogue.getId() + ";\nName: " + catalogue.getName());
        }
        session.getTransaction().commit();
        session.close();
    }
}
