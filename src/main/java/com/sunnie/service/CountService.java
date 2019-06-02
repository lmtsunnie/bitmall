package com.sunnie.service;

import com.sunnie.pojo.dto.OrderChartData;

import java.util.Date;
import java.util.List;

/**
 * @author Sunnie
 */
public interface CountService {

    /**
     * 统计订单销量
     * @param type
     * @param startTime
     * @param endTime
     * @param year
     * @return
     */
    List<OrderChartData> getOrderCountData(int type, Date startTime, Date endTime, int year);
}
