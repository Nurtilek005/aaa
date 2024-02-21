package PeakSoft.repository;

import PeakSoft.entyti.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll();
    User signIn(User user);
    String signUp(User user);
    User findById(Long Id);
    void deleteById(Long Id);
    void updateById(Long Id,User newEntity);
    User getUserByUsername(String username);
}
