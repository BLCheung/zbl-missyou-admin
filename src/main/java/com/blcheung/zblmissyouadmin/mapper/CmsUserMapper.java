package com.blcheung.zblmissyouadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blcheung.zblmissyouadmin.model.CmsUserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author BLCheung
 * @since 2021-11-28
 */
@Repository
public interface CmsUserMapper extends BaseMapper<CmsUserDO> {

    /**
     * 通过id查找人数
     *
     * @param id
     * @return java.lang.Integer
     * @author BLCheung
     * @date 2021/12/17 10:49 下午
     */
    Integer checkCountById(Long id);

    /**
     * 通过用户名查找人数
     *
     * @param username
     * @return java.lang.Integer
     * @author BLCheung
     * @date 2021/12/17 10:50 下午
     */
    Integer checkCountByUsername(String username);

    /**
     * 根据分组级别获取用户分页
     *
     * @param page
     * @param level
     * @return java.util.List<com.blcheung.zblmissyouadmin.model.CmsUserDO>
     * @author BLCheung
     * @date 2022/1/24 2:50 上午
     */
    Page<CmsUserDO> getUserPageByGroupLevel(Page<CmsUserDO> page, Integer level);

    /**
     * 根据分组id获取用户分页
     *
     * @param page
     * @param groupId
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.blcheung.zblmissyouadmin.model.CmsUserDO>
     * @author BLCheung
     * @date 2022/1/24 10:43 下午
     */
    Page<CmsUserDO> getUserPageByGroupId(Page<CmsUserDO> page, @Param("groupId") Long groupId);
}
