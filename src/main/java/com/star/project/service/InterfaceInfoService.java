package com.star.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.star.starcommon.model.entity.InterfaceInfo;


/**
 * 接口信息服务
 *
 * @author <a href="https://github.com/listar">程序员鱼皮</a>
 * @from <a href="https://star.icu">编程导航知识星球</a>
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}