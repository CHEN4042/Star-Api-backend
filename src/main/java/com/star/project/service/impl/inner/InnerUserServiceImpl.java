package com.star.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.star.project.common.ErrorCode;
import com.star.project.exception.BusinessException;
import com.star.project.mapper.UserMapper;

import com.star.starcommon.model.entity.User;
import com.star.starcommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部用户服务实现类
 *
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    // [编程知识星球](https://star.icu) 零基础快速入门编程，不走弯路！30+ 原创学习路线和专栏、1000+ 编程精华文章、500+ 编程学习指南、20T+ 编程资源汇总

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
