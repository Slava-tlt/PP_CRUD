package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getById(Long id);

    public void update(Long id, User user);

    public void delete(Long id);
}
