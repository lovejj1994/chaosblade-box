/*
 * Copyright 1999-2021 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.chaosblade.box.dao.repository;

import com.alibaba.chaosblade.box.dao.QueryWrapperBuilder;
import com.alibaba.chaosblade.box.dao.mapper.ExperimentActivityMapper;
import com.alibaba.chaosblade.box.dao.mapper.ExperimentActivityTaskRecordMapper;
import com.alibaba.chaosblade.box.dao.model.ExperimentActivityDO;
import com.alibaba.chaosblade.box.dao.model.ExperimentActivityTaskRecordDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author yefei
 */
@Repository
public class ExperimentActivityTaskRecordRepository extends ServiceImpl<ExperimentActivityTaskRecordMapper, ExperimentActivityTaskRecordDO>
        implements IRepository<Long, ExperimentActivityTaskRecordDO> {

    @Autowired
    private ExperimentActivityTaskRecordMapper experimentActivityTaskRecordMapper;

    @Override
    public Optional<ExperimentActivityTaskRecordDO> selectById(Long aLong) {
        return Optional.ofNullable(experimentActivityTaskRecordMapper.selectById(aLong));
    }

    public List<ExperimentActivityTaskRecordDO> selectBySceneCode(Long experimentTaskId, String sceneCode) {
        QueryWrapper<ExperimentActivityTaskRecordDO> queryWrapper = QueryWrapperBuilder.build();
        queryWrapper.lambda().eq(ExperimentActivityTaskRecordDO::getExperimentTaskId, experimentTaskId);
        queryWrapper.lambda().eq(ExperimentActivityTaskRecordDO::getSceneCode, sceneCode);
        return experimentActivityTaskRecordMapper.selectList(queryWrapper);
    }

    @Override
    public Long insert(ExperimentActivityTaskRecordDO experimentActivityTaskRecordDO) {
        experimentActivityTaskRecordMapper.insert(experimentActivityTaskRecordDO);
        return experimentActivityTaskRecordDO.getId();
    }

    @Override
    public boolean updateByPrimaryKey(Long id, ExperimentActivityTaskRecordDO experimentActivityTaskRecordDO) {
        experimentActivityTaskRecordDO.setId(id);
        return experimentActivityTaskRecordMapper.updateById(experimentActivityTaskRecordDO) == 1;
    }

    public List<ExperimentActivityTaskRecordDO> selectExperimentTaskId(Long experimentTaskId) {
        QueryWrapper<ExperimentActivityTaskRecordDO> queryWrapper = QueryWrapperBuilder.build();
        queryWrapper.lambda().eq(ExperimentActivityTaskRecordDO::getExperimentTaskId, experimentTaskId);
        return experimentActivityTaskRecordMapper.selectList(queryWrapper);
    }

    public List<ExperimentActivityTaskRecordDO> selectActivityTaskId(Long activityTaskId) {
        QueryWrapper<ExperimentActivityTaskRecordDO> queryWrapper = QueryWrapperBuilder.build();
        queryWrapper.lambda().eq(ExperimentActivityTaskRecordDO::getActivityTaskId, activityTaskId);
        return experimentActivityTaskRecordMapper.selectList(queryWrapper);
    }
}

