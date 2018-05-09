package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.UserDAO;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Autowired
    private UserDAO userDAO;

    public void save(String name, int age) {
        if (name != null && age > 0) userDAO.save(new User(name, age));
    }

    public void save(User user) {
        if (user != null) userDAO.save(user);
    }
}
