package com.yimo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yimo.common.model.entity.Menu;
import com.yimo.user.model.dto.menu.MenuItem;

import java.util.List;

/**
* @author LiuCheng
* @description 针对表【menu】的数据库操作Service
* @createDate 2023-03-04 14:11:39
*/
public interface MenuService extends IService<Menu> {
    List<MenuItem> getUserMenuList();

    List<MenuItem> getAdminMenuList();
}
