package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
//  @Override
  //  public void add(User user) {
  //      sessionFactory.getCurrentSession().save(user);
   // }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public void saveUser(User userSave) {

      //  User user55 = new User(22, "uiuiui", "hhhhh", "kkkkk");
        System.out.println(userSave);
       // System.out.println(user55);
        entityManager.persist(userSave);
      //  entityManager.close();
    }

}
