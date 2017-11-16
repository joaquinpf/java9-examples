package com.sparkdigital.java9.examples.flow;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class FlowTest {

    @Test
    public void flowTest() throws Exception {
        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Create Processor and Subscriber
        FilterProcessor<String> filterProcessor = new FilterProcessor<>(s -> s.equals("x"));

        TransformProcessor<String, Integer> transformProcessor = new TransformProcessor<>(s -> Integer.parseInt(s));

        PrinterSubscriber<Integer> subscriber = new PrinterSubscriber<>();

        //Chain Processor and Subscriber
        publisher.subscribe(filterProcessor);
        filterProcessor.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);

        System.out.println("Publishing Items...");
        List.of("1", "x", "2", "x", "3", "x").stream().forEach(i -> publisher.submit(i));
        publisher.close();

        Thread.sleep(100);
    }

}
