package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TNotice;
import com.skytech.api.model.TNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TNoticeMapper extends GenericOneMapper<TNotice,TNoticeExample,Integer> {
}