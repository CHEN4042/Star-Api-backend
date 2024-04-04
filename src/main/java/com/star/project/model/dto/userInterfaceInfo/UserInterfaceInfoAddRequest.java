package com.star.project.model.dto.userInterfaceInfo;


import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 调用用户Id
     */
    private Long userId;

    /**
     * 接口Id
     */
    private Long interfaceInfo_id;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;
}