package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
         return userDao.getUsers();
    }

    @Transactional()
    @Override
    public void saveUser(User userSave) {
        userDao.saveUser(userSave);
    }
    @Transactional()
    @Override
    public void deleteUser(Long id) { userDao.deleteUser(id);}
    @Transactional()
    @Override
    public User findUser(Long id) {
        return userDao.findUser(id);
    }
    @Transactional()
    @Override
    public void updateUser(User userUpdate) {
        userDao.updateUser(userUpdate);
    }


}
