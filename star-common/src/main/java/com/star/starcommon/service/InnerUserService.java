package com.star.starcommon.service;


import com.star.starcommon.model.entity.User;

/**
 * 内部用户服务
 *
 * @author <a href="https://github.com/listar">程序员鱼皮</a>
 * @from <a href="https://star.icu">编程导航知识星球</a>
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户秘钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
