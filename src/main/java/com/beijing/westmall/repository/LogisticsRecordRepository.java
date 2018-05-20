package com.beijing.westmall.repository;

import com.beijing.westmall.entity.LogisticsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:31 2018/5/16
 */
public interface LogisticsRecordRepository extends JpaRepository<LogisticsRecord,Long>{

    public LogisticsRecord findLogisticsRecordByIdAndOrderId(@Param("orderId") Long id,@Param("orderId") Long orderId);
}
