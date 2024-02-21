package PeakSoft.repository;

import PeakSoft.entyti.Follower;

import java.util.List;

public interface FollowerRepo {
    List<Follower> findAll();
    void save(Follower follower);
    Follower findById(Long Id);
    void deleteById(Long Id);
    void updateById(Long Id,Follower newEntity);
}
