package com.flume.example;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.source.AbstractSource;

import java.util.LinkedList;
import java.util.List;

public class CustomSource extends AbstractSource implements Configurable, PollableSource {
    @Override
    public void configure(Context context) {

    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public synchronized void stop() {
        super.stop();
    }


    @Override
    public Status process() throws EventDeliveryException {
        try {
            List<Event> events = new LinkedList<>();
            getChannelProcessor().processEventBatch(events);
            return Status.READY;
        } catch (Exception e) {
            return Status.BACKOFF;
        }
    }

    @Override
    public long getBackOffSleepIncrement() {
        return 0;
    }

    @Override
    public long getMaxBackOffSleepInterval() {
        return 0;
    }
}
