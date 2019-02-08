package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.Distances;

public interface DistancesService extends GenericService<Distances, String> {

    Pagination<Distances> findForPage(int page, int limit);

    JsonMap save(Distances distances);

    JsonMap update(String distancesSid, Distances distances);

    JsonMap delete(String... distancesSids);

    JsonMap doSynchronous(String accountSid, Distances distances);

    Distances getNewest(String accountSid);
}


