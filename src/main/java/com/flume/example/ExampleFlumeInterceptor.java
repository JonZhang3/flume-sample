package com.flume.example;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.List;

// package jar -> /flume/lib
// agent1.sources.r1.interceptors = i1
// agent1.sources.r1.interceptors.i1.type = com.flume.example.ExampleFlumeInterceptor$Builder
public class ExampleFlumeInterceptor implements Interceptor {
    @Override
    public void initialize() {
        System.out.println("init");
    }

    @Override
    public Event intercept(Event event) {
        event.getHeaders().put("test", "example");
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        return list;
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new ExampleFlumeInterceptor();
        }

        @Override
        public void configure(Context context) {
            // 获取配置参数
            // context.getString("");
        }
    }

}
