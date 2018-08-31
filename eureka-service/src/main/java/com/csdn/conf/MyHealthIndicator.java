package com.csdn.conf;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.csdn.action.MyRestController;

/**
 * 自定义健康指示器
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if(MyRestController.isDB){
            return new Health.Builder(Status.UP).build();
        } else{
            return new Health.Builder(Status.DOWN).build();
        }
    }
}