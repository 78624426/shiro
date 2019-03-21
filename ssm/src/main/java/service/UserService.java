package service;

import pojo.User;

public interface UserService {
    void regist(User u);
    String login(User u);
}
