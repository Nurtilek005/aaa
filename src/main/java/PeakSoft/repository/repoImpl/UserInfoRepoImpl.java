package PeakSoft.repository.repoImpl;

import PeakSoft.entyti.UserInfo;
import PeakSoft.repository.UserInfoRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class UserInfoRepoImpl implements UserInfoRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    public UserInfoRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserInfo findUserInfoNyUserId(Long userId) {
        return    entityManager
                .createQuery("select userInfo from UserInfo userInfo where userInfo.user.id = :userID", UserInfo.class)
                .setParameter("userID", userId)
                .getSingleResult();
    }


    @Override
    @Transactional
    public String updateUserInfo(Long userInfoId, UserInfo userInfo) {
        UserInfo userInfo1 = entityManager.find(UserInfo.class, userInfoId);
        userInfo1.setFullName(userInfo.getFullName());
        userInfo1.setBiography(userInfo.getBiography());
        userInfo1.setGender(userInfo.getGender());
        userInfo1.setImage(userInfo.getImage());
        entityManager.merge(userInfo1);
        return "User infos updated!";
    }

    @Override
    public UserInfo getUserInfoById(Long userInfoId) {
        return entityManager.find(UserInfo.class, userInfoId);
    }

    @Override
    public List<UserInfo> getAllUserInfos() {
        return entityManager.createQuery("select u from UserInfo u").getResultList();
    }
}