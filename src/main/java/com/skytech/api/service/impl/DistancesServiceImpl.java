package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.DistancesMapper;
import com.skytech.api.model.Distances;
import com.skytech.api.model.DistancesExample;
import com.skytech.api.model.base.BaseDistancesExample;
import com.skytech.api.service.DistancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("distancesService")
public class DistancesServiceImpl extends GenericServiceImpl<Distances, DistancesExample, String> implements DistancesService {

    @Autowired
    private DistancesMapper distancesMapper;

    @Override
    protected DistancesMapper getGenericMapper() {
        return this.distancesMapper;
    }

    @Override
    public Pagination<Distances> findForPage(int page, int limit) {
        DistancesExample distancesExample = new DistancesExample();
        BaseDistancesExample.Criteria criteria = distancesExample.createCriteria();

        Pagination<Distances> pagination = this.queryByPage(distancesExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Distances distances) {

        DistancesExample distancesExample = new DistancesExample();

        List<Distances> distancess = distancesMapper.selectByExample(distancesExample);

        distances.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        distances.setCreatedDatetime(new Date());
        int i = distancesMapper.insertSelective(distances);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String distancesSid, Distances distances) {
        distances.setSid(distancesSid);
        int i = distancesMapper.updateByPrimaryKeySelective(distances);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... distancesSids) {

        try {
            for (int i = 0; i < distancesSids.length; i++) {
                Distances distances = new Distances();

                distances.setSid(distancesSids[i]);

                distancesMapper.updateByPrimaryKeySelective(distances);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public JsonMap doSynchronous(String accountSid, Distances distances) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(distances.getCreatedDatetime());

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date date1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.SECOND, -1);
        Date date2 = calendar.getTime();

        DistancesExample distancesExample = new DistancesExample();
        distancesExample.createCriteria().andAccountSidEqualTo(accountSid).andCreatedDatetimeBetween(date1, date2);

        List<Distances> distancesList = distancesMapper.selectByExample(distancesExample);

        if (distancesList.isEmpty()) {
            distances.setSid(UUIDUtil.getUUID());
            distances.setAccountSid(accountSid);
            distances.setCreatedDatetime(new Date());

            distancesMapper.insertSelective(distances);
        } else {
            Distances entity = distancesList.get(0);
            entity.setCreatedDatetime(distances.getCreatedDatetime());
            entity.setCal(distances.getCal());
            entity.setDistance(distances.getDistance());
            distancesMapper.updateByPrimaryKeySelective(entity);
        }

        return JsonMap.of(true);
    }

    @Override
    public Distances getNewest(String accountSid) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();
        DistancesExample distancesExample = new DistancesExample();
        distancesExample.createCriteria().andAccountSidEqualTo(accountSid).andCreatedDatetimeBetween(startDate, endDate);

        List<Distances> distancesList = distancesMapper.selectByExample(distancesExample);

        if (distancesList.isEmpty()) {
            return null;
        } else {
            return distancesList.get(0);
        }

    }
}