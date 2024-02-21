package PeakSoft.controller;

import PeakSoft.entyti.UserInfo;
import PeakSoft.service.UserInfoService;
import PeakSoft.service.UserService;
import PeakSoft.service.serviceImpl.UserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class UserInfoController {

    private final UserInfoService userInfoService;
    private final UserService userService;

    public UserInfoController(UserInfoService userInfoService, UserService userService) {
        this.userInfoService = userInfoService;
        this.userService = userService;
    }

    @GetMapping
    public String oftenProfile(Model model){
        model.addAttribute("currentUser", userService.getUserByUsername(String.valueOf(UserServiceImpl.current.getId())));
        return "/profile";
    }

    @GetMapping("/newUserInfo/{userId}")
    public String createNewInfo(@PathVariable Long userId, Model model) {
        UserInfo userInfo = userService.findById(userId).getUserInfo();
        model.addAttribute("foundUserInfo", userInfo);
        // изменено на "userInfo"
        return "/editProfil";
    }

    @PostMapping("/saveUserInfo/{userInfoId}")
    public String updateUserInfo(@ModelAttribute("foundUserInfo") UserInfo userInfo,
                                 @PathVariable Long userInfoId) {
        userInfoService.updateUserInfo(userInfoId, userInfo);
        return "redirect:/userInfos";
    }
}

