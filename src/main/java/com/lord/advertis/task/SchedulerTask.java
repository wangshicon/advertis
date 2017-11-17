package com.lord.advertis.task;

import com.lord.advertis.domain.Browse;
import com.lord.advertis.enums.ResultEnum;
import com.lord.advertis.exception.AdvertisException;
import com.lord.advertis.service.BrowseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.lord.advertis.consts.Brows.BROWS_AMOUNT;

/**
 *
 * 定时任务实现类
 * Created by on 2017/11/17.
 */
@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private BrowseService browseService;

    /**
     *
     * @Title: executeTodayCounterTask
     * @Description: 浏览量定时任务
     * @return
     * @author Lord
     * @date 2017年11月17日 下午14:26:18
     */
    @Scheduled(cron="0 0 23 * * ?")
    public void executeTodayCounterTask() {
        Browse browse = new Browse();
        browse.setCreatedate(new Date());
        browse.setNumber(BROWS_AMOUNT);
        Integer flag = browseService.insert(browse);

        if (flag > 0){
            BROWS_AMOUNT = 0;
            logger.info("浏览量增加定时任务成功：" + dateFormat.format(new Date())+ ",todayTotal:"+BROWS_AMOUNT);
        } else {
            throw new AdvertisException(ResultEnum.TASK_ERROR);
        }
    }

}