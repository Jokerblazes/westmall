package com.beijing.westmall.controller;

import com.beijing.westmall.common.Utils;
import com.beijing.westmall.entity.LogisticsRecord;
import com.beijing.westmall.repository.LogisticsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Joker
 * @Description
 * @Date Create in 上午10:56 2018/5/19
 */
@RestController
@RequestMapping(value = "/logisticsRecords")
public class LogisticRecordController {
    @Autowired
    private LogisticsRecordRepository logisticsRecordRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public LogisticsRecord getLogisticRecordById(@PathVariable Long id) {
        return logisticsRecordRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}/orders/{orderId}")
    public ResponseEntity updateByIdAndOrderId(@PathVariable Long id, @PathVariable Long orderId, @Param("logisticsStatus") String logisticsStatus) {
        LogisticsRecord logisticsRecord = logisticsRecordRepository.findLogisticsRecordByIdAndOrderId(id,orderId);
        logisticsRecord.setLogisticsStatus(logisticsStatus);
        logisticsRecord.setSignedOrOutboundTime();
        logisticsRecordRepository.save(logisticsRecord);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
