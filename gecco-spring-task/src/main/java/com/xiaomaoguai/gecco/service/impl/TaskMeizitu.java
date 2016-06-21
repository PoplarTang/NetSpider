package com.xiaomaoguai.gecco.service.impl;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import com.xiaomaoguai.gecco.common.utils.SpringContextUtil;
import com.xiaomaoguai.gecco.entity.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明 :
 * 作者 : WeiHui.jackson
 * 日期 : 2016/4/27 16:26
 * 版本 : 1.0.0
 */
@Service
public class TaskMeizitu  implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("任务名称 = [" + scheduleJob.getName() + "]" + " 在 " + dateFormat.format(new Date()) + " 时运行");

        SpringPipelineFactory springPipelineFactory = SpringContextUtil.getBean("springPipelineFactory");

        HttpGetRequest start = new HttpGetRequest("http://www.meizitu.com/");
        start.setCharset("GBK");
        GeccoEngine.create()
                .pipelineFactory(springPipelineFactory)
                .classpath("com.xiaomaoguai.gecco.crawler")
                .start(start)
                .loop(false)
                .run();
    }
}