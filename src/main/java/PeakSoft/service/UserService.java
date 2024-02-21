package PeakSoft.service;

import PeakSoft.entyti.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface UserService {
    List<User> findAll();
    User signIn(User user);
    void signUp(User user);
    User findById(Long Id);
    void deleteById(Long Id);
    void updateById(Long Id,User newEntity);
    User getUserByUsername(String username);
}
