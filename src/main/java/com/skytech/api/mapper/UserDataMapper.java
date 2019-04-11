package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.UserData;
import com.skytech.api.model.UserDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDataMapper extends GenericOneMapper<UserData,UserDataExample,Integer>{

}