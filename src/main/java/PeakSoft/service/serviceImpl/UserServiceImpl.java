package PeakSoft.service.serviceImpl;

import PeakSoft.entyti.User;
import PeakSoft.repository.UserRepo;
import PeakSoft.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
   private final UserRepo userRepo;
   public static User current;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User signIn(User user) {
current=userRepo.signIn(user);
        return user;
    }

    @Override
    public void signUp(User user) {
userRepo.signUp(user);
    }

    @Override
    public User findById(Long Id) {
        return userRepo.findById(Id);
    }

    @Override
    public void deleteById(Long Id) {
userRepo.deleteById(Id);
    }

    @Override
    public void updateById(Long Id, User newEntity) {
userRepo.updateById(Id,newEntity);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }
}
