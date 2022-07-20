package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    void saveUser(User user);

    public User getById(Long id);

    public void update(Long id, User user);

    public void delete(Long id);
}
