package euporia;

import euporia.database.usermanagement.User;
import euporia.utils.DbUtils;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

public class EndpointTests extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String password = BCrypt.hashpw("testPwd", BCrypt.gensalt());
        Session session = DbUtils.getInstance().getSession();
        session.beginTransaction();
        session.save(new User("testUser", "test@user.com", password, "", ""));
        session.close();
    }

    public void testLogin() {

    }
}
