package PeakSoft.service.serviceImpl;

import PeakSoft.entyti.UserInfo;
import PeakSoft.repository.UserInfoRepo;
import PeakSoft.service.UserInfoService;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
 private final UserInfoRepo userInfoRepo;

    public UserInfoServiceImpl(UserInfoRepo userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }


    @Override
    public UserInfo findUserInfoNyUserId(Long userId) {
        return userInfoRepo.findUserInfoNyUserId(userId);
    }

    @Override
    public String updateUserInfo(Long userInfoId, UserInfo userInfo) {
        return userInfoRepo.updateUserInfo(userInfoId,userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Long userInfoId) {
        return userInfoRepo.getUserInfoById(userInfoId);
    }

    @Override
    public List<UserInfo> getAllUserInfos() {
        return userInfoRepo.getAllUserInfos();
    }
}
