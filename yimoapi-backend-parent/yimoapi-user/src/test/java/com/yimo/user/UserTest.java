package com.yimo.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yimo.common.model.entity.User;
import com.yimo.user.service.TokenService;
import com.yimo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 刘呈
 * @Date: 2023/02/23/14:00
 * @Description:
 */
@SpringBootTest
public class UserTest {
    @Resource
    UserService userService;

    @Resource
    TokenService tokenService;
    @Test
    void test001(){
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        List<User> users = baseMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testToken(){
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        User user = baseMapper.selectById(1);
        String grant = tokenService.grant(user);
        System.out.println(grant);
        User user1 = tokenService.validateAndGetUserInfo(grant);
        System.out.println(user1);
    }
}
