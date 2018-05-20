package com.beijing.westmall.repository;

import com.beijing.westmall.entity.LogisticsRecord;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.junit.Assert.*;
/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:30 2018/5/16
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class LogisticsRecordRepositoryTest {

    @Autowired
    private LogisticsRecordRepository logisticsRecordRepository;

    @Before
    public void setUp() throws Exception {
        //本地启动mysql，创建employee_db数据库
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/westmall","root","123456");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void testFindLogisticsRecordByOrderId() {
        LogisticsRecord logisticsRecord = logisticsRecordRepository.findLogisticsRecordByIdAndOrderId((long) 1,(long) 1);
        assertNotNull(logisticsRecord);
        assertEquals(logisticsRecord.getId(),Long.valueOf(1));
    }

}
