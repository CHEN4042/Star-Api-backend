package com.star.starcommon.service;

import com.star.starcommon.model.entity.InterfaceInfo;

/**
 * 内部接口信息服务
 *
 * @author <a href="https://github.com/listar">程序员鱼皮</a>
 * @from <a href="https://star.icu">编程导航知识星球</a>
 */
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
