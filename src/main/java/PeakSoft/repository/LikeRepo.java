package PeakSoft.repository;

import PeakSoft.entyti.Like;

import java.util.List;

public interface LikeRepo {
    List<Like> findAll();
    void save(Like like);
    Like findById(Long Id);
    void deleteById(Long Id);
    void updateById(Long Id,Like newEntity);
}
