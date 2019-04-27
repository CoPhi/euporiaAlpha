package euporia.utils;

import euporia.database.usermanagement.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

public class LoginUtils {

    public static boolean login(String username, String password) {
        try {
            Session session = DbUtils.getInstance().getSession();
            session.beginTransaction();
            Query query = session.createQuery("SELECT password from Users WHERE user = :username");
            query.setParameter("username", username);
            User user = (User) query.uniqueResult();
            session.close();
            return BCrypt.checkpw(password, user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
