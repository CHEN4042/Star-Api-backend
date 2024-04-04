package com.star.starcommon.service;

/**
 * 内部用户接口信息服务
 *
 * @author <a href="https://github.com/listar">程序员鱼皮</a>
 * @from <a href="https://star.icu">编程导航知识星球</a>
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
