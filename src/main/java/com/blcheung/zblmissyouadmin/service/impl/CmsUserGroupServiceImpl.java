package com.blcheung.zblmissyouadmin.service.impl;

import com.blcheung.zblmissyouadmin.model.CmsUserGroupDO;
import com.blcheung.zblmissyouadmin.mapper.CmsUserGroupMapper;
import com.blcheung.zblmissyouadmin.service.CmsUserGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BLCheung
 * @since 2021-11-28
 */
@Service
public class CmsUserGroupServiceImpl extends ServiceImpl<CmsUserGroupMapper, CmsUserGroupDO>
        implements CmsUserGroupService {

    @Override
    public List<Long> getGroupAllUserIds(Long groupId) {
        List<CmsUserGroupDO> userGroupRelations = this.lambdaQuery()
                                                      .eq(CmsUserGroupDO::getGroupId, groupId)
                                                      .list();

        return userGroupRelations.stream()
                                 .map(CmsUserGroupDO::getUserId)
                                 .collect(Collectors.toList());
    }
}
