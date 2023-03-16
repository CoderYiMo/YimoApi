package com.yimo.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimo.common.model.entity.Menu;
import com.yimo.user.mapper.MenuMapper;
import com.yimo.user.model.dto.menu.MenuItem;
import com.yimo.user.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author LiuCheng
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-03-04 14:11:39
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService {

    @Override
    public List<MenuItem> getUserMenuList() {
//        总的返回列表
        ArrayList<MenuItem> result = new ArrayList<>();
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.eq("role","user");
        List<Menu> menus = getBaseMapper().selectList(menuQueryWrapper);
        for(Menu menu : menus){
            MenuItem menuItem = new MenuItem();
            menuItem.setMenuName(menu.getMenuName());
            QueryWrapper<Menu> menuQueryWrapper1 = new QueryWrapper<>();
            menuQueryWrapper1.eq("parent_id",menu.getId());
            List<Menu> menus1 = getBaseMapper().selectList(menuQueryWrapper1);
            //创建子列表
            ArrayList<MenuItem> menuItems = new ArrayList<>();
            for (Menu menu1 : menus1){
                MenuItem menuItem1 = new MenuItem();
                menuItem1.setMenuName(menu1.getMenuName());
                menuItem1.setUrl(menu1.getUrl());
                menuItem1.setMenuItemList(null);
                menuItems.add(menuItem1);
            }
            menuItem.setMenuItemList(menuItems);
            result.add(menuItem);
        }
        return result;
    }

    @Override
    public List<MenuItem> getAdminMenuList() {
        //        总的返回列表
        ArrayList<MenuItem> result = new ArrayList<>();
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.eq("role","admin");
        List<Menu> menus = getBaseMapper().selectList(menuQueryWrapper);
        for(Menu menu : menus){
            MenuItem menuItem = new MenuItem();
            menuItem.setMenuName(menu.getMenuName());
            QueryWrapper<Menu> menuQueryWrapper1 = new QueryWrapper<>();
            menuQueryWrapper1.eq("parent_id",menu.getId());
            List<Menu> menus1 = getBaseMapper().selectList(menuQueryWrapper1);
            //创建子列表
            ArrayList<MenuItem> menuItems = new ArrayList<>();
            for (Menu menu1 : menus1){
                MenuItem menuItem1 = new MenuItem();
                menuItem1.setMenuName(menu1.getMenuName());
                menuItem1.setUrl(menu1.getUrl());
                menuItem1.setMenuItemList(null);
                menuItems.add(menuItem1);
            }
            menuItem.setMenuItemList(menuItems);
            result.add(menuItem);
        }
        return result;
    }
}




