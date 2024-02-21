package PeakSoft.service;

import PeakSoft.entyti.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo findUserInfoNyUserId(Long userId);

    String updateUserInfo(Long userInfoId, UserInfo userInfo);

    UserInfo getUserInfoById(Long userInfoId);


    List<UserInfo> getAllUserInfos();
}
