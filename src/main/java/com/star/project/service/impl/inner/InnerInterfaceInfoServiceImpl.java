package com.star.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.star.project.common.ErrorCode;
import com.star.project.exception.BusinessException;
import com.star.project.mapper.InterfaceInfoMapper;
import com.star.starcommon.model.entity.InterfaceInfo;
import com.star.starcommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部接口服务实现类
 *
 * @author <a href="https://github.com/listar">程序员鱼皮</a>
 * @from <a href="https://star.icu">编程导航知识星球</a>
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }


}
