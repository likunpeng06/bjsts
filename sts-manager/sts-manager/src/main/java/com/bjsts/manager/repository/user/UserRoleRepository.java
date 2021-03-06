package com.bjsts.manager.repository.user;

import com.bjsts.manager.entity.user.UserRoleEntity;
import com.bjsts.manager.core.repository.IRepository;

import java.util.List;

/**
 * @author jinsheng
 * @since 2016-04-27 14:53
 */
public interface UserRoleRepository extends IRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findByUserId(Long userId);
}
