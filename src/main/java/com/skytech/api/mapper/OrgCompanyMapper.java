package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.OrgCompany;
import com.skytech.api.model.OrgCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgCompanyMapper extends GenericOneMapper<OrgCompany,OrgCompanyExample,Integer>{

}