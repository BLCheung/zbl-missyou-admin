package com.blcheung.zblmissyouadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blcheung.zblmissyouadmin.common.enumeration.GroupLevel;
import com.blcheung.zblmissyouadmin.common.token.Tokens;
import com.blcheung.zblmissyouadmin.dto.cms.LoginDTO;
import com.blcheung.zblmissyouadmin.dto.cms.RegisterUserDTO;
import com.blcheung.zblmissyouadmin.dto.cms.UpdateUserInfoDTO;
import com.blcheung.zblmissyouadmin.model.CmsPermissionDO;
import com.blcheung.zblmissyouadmin.model.CmsUserDO;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author BLCheung
 * @since 2021-11-28
 */
public interface CmsUserService extends IService<CmsUserDO> {
    /**
     * 注册用户
     *
     * @param registerUserDTO
     * @return com.blcheung.zblmissyouadmin.model.CmsUserDO
     * @author BLCheung
     * @date 2021/12/13 9:03 下午
     */
    CmsUserDO registerUser(RegisterUserDTO registerUserDTO);

    /**
     * 登录
     *
     * @param loginDTO
     * @return com.blcheung.zblmissyouadmin.common.token.Tokens
     * @author BLCheung
     * @date 2021/12/30 10:37 下午
     */
    Tokens login(LoginDTO loginDTO);

    /**
     * 更新用户信息
     *
     * @param dto
     * @return com.blcheung.zblmissyouadmin.model.CmsUserDO
     * @author BLCheung
     * @date 2022/1/27 10:45 下午
     */
    Optional<CmsUserDO> update(UpdateUserInfoDTO dto);

    /**
     * 通过用户名检查用户是否存在
     *
     * @param username
     * @return java.lang.Boolean
     * @author BLCheung
     * @date 2021/12/13 9:03 下午
     */
    Boolean checkUserExistByUserName(String username);

    /**
     * 通过邮箱检查用户是否存在
     *
     * @param email
     * @return java.lang.Boolean
     * @author BLCheung
     * @date 2021/12/17 10:54 下午
     */
    Boolean checkUserExistByEmail(String email);

    /**
     * 通过id获取用户
     *
     * @param userId
     * @return java.util.Optional<com.blcheung.zblmissyouadmin.model.CmsUserDO>
     * @author BLCheung
     * @date 2022/1/25 8:07 下午
     */
    Optional<CmsUserDO> getUserByUserId(Long userId);

    /**
     * 通过用户名获取用户
     *
     * @param userName
     * @return java.util.Optional<com.blcheung.zblmissyouadmin.model.CmsUserDO>
     * @author BLCheung
     * @date 2021/12/30 10:42 下午
     */
    Optional<CmsUserDO> getUserByUserName(String userName);

    /**
     * 获取用户拥有的权限
     *
     * @param uid
     * @return java.util.List<com.blcheung.zblmissyouadmin.model.CmsPermissionDO>
     * @author BLCheung
     * @date 2022/1/11 2:42 上午
     */
    List<CmsPermissionDO> getUserPermissions(Long uid);

    /**
     * 获取>=level的分组级别用户分页
     *
     * @param page
     * @param level
     * @return java.util.List<com.blcheung.zblmissyouadmin.vo.cms.UserVO>
     * @author BLCheung
     * @date 2022/1/24 2:52 上午
     */
    Page<CmsUserDO> getUserPageByGroupLevelGE(Page<CmsUserDO> page, GroupLevel level);

    /**
     * 获取==level的分组级别用户分页
     *
     * @param page
     * @param level
     * @return java.util.List<com.blcheung.zblmissyouadmin.vo.cms.UserVO>
     * @author BLCheung
     * @date 2022/1/24 2:52 上午
     */
    Page<CmsUserDO> getUserPageByGroupLevelEQ(Page<CmsUserDO> page, GroupLevel level);

    /**
     * 超级管理员获取所有用户包括管理员的分页
     *
     * @param page
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.blcheung.zblmissyouadmin.model.CmsUserDO>
     * @author BLCheung
     * @date 2022/1/24 2:52 上午
     */
    Page<CmsUserDO> getUserAdminPageByRoot(Page<CmsUserDO> page);

    /**
     * 超级管理员获取所有管理员级别分页
     *
     * @param page
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.blcheung.zblmissyouadmin.model.CmsUserDO>
     * @author BLCheung
     * @date 2022/1/25 3:03 上午
     */
    Page<CmsUserDO> getAdminPageByRoot(Page<CmsUserDO> page);

    /**
     * 根据分组id获取用户分页
     *
     * @param page
     * @param groupId
     * @return java.util.List<com.blcheung.zblmissyouadmin.vo.cms.UserVO>
     * @author BLCheung
     * @date 2022/1/24 2:53 上午
     */
    Page<CmsUserDO> getUserPageByGroupId(Page<CmsUserDO> page, Long groupId);
}
