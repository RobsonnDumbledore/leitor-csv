package com.codart;

import com.codart.tasks.ScheduleTask;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableScheduling
@SpringBootApplication
public class SynchronizerApplication {

    public static void main(String[] args) {
        ScheduleTask task = new ScheduleTask();
        task.start(args[0]);
    }

}
