package dao;

import pojo.User;

public interface UserDao {
    void insert(User u);
    User selectUser(String name);
}
