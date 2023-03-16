package com.yimo.interfaceinfo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yimo.common.model.entity.InterfaceInfo;

/**
* @author LiuCheng
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-02-24 15:40:03
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
