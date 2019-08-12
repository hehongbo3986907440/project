package com.example.mapper.orgmapper.impl;

import com.example.entity.org.OrgEntity;
import com.example.mapper.orgmapper.IOrgMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("orgMapper")
public class OrgMapperImpl implements IOrgMapper {
    @Override
    public List<OrgEntity> getOrgs() {
        return null;
    }
}
