package com.sparkdigital.java9.examples.process;

import org.junit.Test;

public class ProcessTests {

    @Test
    public void processApiTests() {
        // Access the current process PID
        ProcessHandle.current().pid();

        // Access the current process metadata, such as command line, working dir, etc.
        ProcessHandle.current().info();

        // Access a stream of first level children processes
        ProcessHandle.current().children();

        // Access a stream of descendant processes
        ProcessHandle.current().descendants();

        // There are also methods to destroy() or destroyForcibly() a process

        // Access a stream of all running processes
        ProcessHandle.allProcesses();
    }
}
