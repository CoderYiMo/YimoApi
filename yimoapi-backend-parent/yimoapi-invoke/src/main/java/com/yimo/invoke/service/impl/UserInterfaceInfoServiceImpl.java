package com.yimo.invoke.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimo.common.model.entity.UserInterfaceInfo;
import com.yimo.invoke.mapper.UserInterfaceInfoMapper;
import com.yimo.invoke.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author LiuCheng
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-02-24 20:45:05
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

}




