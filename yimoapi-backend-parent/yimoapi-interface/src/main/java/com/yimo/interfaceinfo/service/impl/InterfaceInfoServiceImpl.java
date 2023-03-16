package com.yimo.interfaceinfo.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimo.common.base.ErrorCode;
import com.yimo.common.exception.BusinessException;
import com.yimo.interfaceinfo.mapper.InterfaceInfoMapper;
import com.yimo.interfaceinfo.service.InterfaceInfoService;
import com.yimo.common.model.entity.InterfaceInfo;
import org.springframework.stereotype.Service;
import

/**
* @author LiuCheng
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-02-24 15:40:03
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StrUtil.isBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StrUtil.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




