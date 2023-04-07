package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void saveUser(User userSave);

    void deleteUser(Long id);

    User findUser(Long id);

    void updateUser(User userUpdate);
}
