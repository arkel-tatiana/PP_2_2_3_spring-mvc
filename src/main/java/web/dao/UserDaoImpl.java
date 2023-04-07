package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();

    }

    @Override
    public void saveUser(User userSave) {
        entityManager.persist(userSave);
    }

    @Override
    public void deleteUser(Long idDelete) {

        Query query = entityManager.createQuery("delete from User where id =: id_user");
        query.setParameter("id_user", idDelete).executeUpdate();
    }

    @Override
    public User findUser(Long idFind) {
        User findUser = entityManager.find(User.class, idFind);
        return findUser;
      //  TypedQuery<User> query = entityManager.createQuery("from User where id =: id_user", User.class);
      //  return query.setParameter("id_user", idFind).getSingleResult();
    }

    @Override
    public void updateUser(User userUpdate) {

        System.out.println(userUpdate);
       entityManager.merge(userUpdate);
    }

}
