package com.yimo.user.controller;

import com.yimo.common.base.BaseResponse;
import com.yimo.common.util.ResultUtils;
import com.yimo.user.model.dto.menu.MenuItem;
import com.yimo.user.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 刘呈
 * @Date: 2023/03/04/14:31
 * @Description:
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    MenuService menuService;
    @GetMapping("/user")
    public BaseResponse<List<MenuItem>> getUserMenu(){
        List<MenuItem> userMenuList = menuService.getUserMenuList();
        return ResultUtils.success(userMenuList,"获取用户菜单成功");
    }

    @GetMapping("/admin")
    public BaseResponse<List<MenuItem>> getAdminMenu(){
        List<MenuItem> adminMenuList = menuService.getAdminMenuList();
        return ResultUtils.success(adminMenuList,"获取管理员菜单成功");
    }
}
