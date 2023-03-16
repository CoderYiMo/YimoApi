package com.yimo.user.model.dto.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 刘呈
 * @Date: 2023/03/04/14:17
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    private String menuName;
    private String url;

    private List<MenuItem> menuItemList;
}
