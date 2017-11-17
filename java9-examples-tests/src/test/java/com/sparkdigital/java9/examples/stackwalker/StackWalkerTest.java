package com.sparkdigital.java9.examples.stackwalker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StackWalkerTest {

    @Test
    public void getCallerClassTest() {
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        String callerClass = walker.getCallerClass().toGenericString();
        assertThat(callerClass).isEqualTo("class org.junit.runners.model.FrameworkMethod$1");
    }

    @Test
    public void getAllFramesTest() {
        List<StackWalker.StackFrame> stack =
                StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).walk((s) -> s.collect(Collectors.toList()));
        System.out.println("All frames : \n" + stack.toString());
    }


    @Test
    public void filterFramesTest() {
        List<Class> interestingClasses = new ArrayList<>();
        interestingClasses.add(StackWalkerTest.class);
        Optional<StackWalker.StackFrame> framesWithInterestingClass = StackWalker
                .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk((s) -> s.filter(f -> interestingClasses.contains(f.getDeclaringClass())).findFirst());
        System.out.println("Frame with interseting class : \n" + framesWithInterestingClass.toString());
    }

    @Test
    public void skipFramesTest() {
        List<StackWalker.StackFrame> framesAfterSkip = StackWalker
                .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk((s) -> s.skip(2).collect(Collectors.toList()));
        System.out.println("Frames after skip : \n" + framesAfterSkip.toString());
    }
}
