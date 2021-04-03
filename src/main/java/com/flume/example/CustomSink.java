package com.flume.example;

import org.apache.flume.Channel;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.Transaction;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;

public class CustomSink extends AbstractSink implements Configurable {

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
        Channel channel = getChannel();
        Transaction txn = channel.getTransaction();
        try {
            for(int i = 0; i < 100; i++) {
                Event event = channel.take();
                // process event
            }
            txn.commit();
            return Status.READY;
        } catch (Exception e) {
            txn.rollback();
            return Status.BACKOFF;
        }
    }

    @Override
    public void configure(Context context) {

    }
}
