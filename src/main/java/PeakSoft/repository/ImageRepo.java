package PeakSoft.repository;

import PeakSoft.entyti.Image;

import java.util.List;

public interface ImageRepo {
    List<Image> findAll();
    void save(Image image);
    Image findById(Long Id);
    void deleteById(Long Id);
    void updateById(Long Id,Image newEntity);

}
