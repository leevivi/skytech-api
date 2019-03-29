package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.OrgStores;
import com.skytech.api.model.OrgStoresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgStoresMapper extends GenericOneMapper<OrgStores,OrgStoresExample,Integer>{
}