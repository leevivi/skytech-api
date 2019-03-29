package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TMemberHistory;
import com.skytech.api.model.TMemberHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import sun.security.x509.GeneralNameInterface;

public interface TMemberHistoryMapper extends GenericOneMapper<TMemberHistory,TMemberHistoryExample,Integer>{
}