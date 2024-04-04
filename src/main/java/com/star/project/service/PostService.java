package com.star.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.star.project.model.entity.Post;

/**
 * 帖子服务
 *
 * @author <a href="https://github.com/listar">程序员鱼皮</a>
 * @from <a href="https://star.icu">编程导航知识星球</a>
 */
public interface PostService extends IService<Post> {

    /**
     * 校验
     *
     * @param post
     * @param add 是否为创建校验
     */
    void validPost(Post post, boolean add);
}
