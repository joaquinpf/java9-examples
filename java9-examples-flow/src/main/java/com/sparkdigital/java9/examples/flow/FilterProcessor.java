package com.sparkdigital.java9.examples.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class FilterProcessor<T> extends SubmissionPublisher<T> implements Flow.Processor<T, T> {

    private final Function<? super T, Boolean> function;
    private Flow.Subscription subscription;

    public FilterProcessor(Function<? super T, Boolean> function) {
        super();
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        if (!function.apply(item)) {
            submit(item);
        }
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }
}  