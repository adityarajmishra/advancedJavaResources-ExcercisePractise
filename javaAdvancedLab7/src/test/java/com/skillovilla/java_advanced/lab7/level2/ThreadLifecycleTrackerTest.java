package com.skillovilla.java_advanced.lab7.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadLifecycleTrackerTest {

    @Test
    public void testThreadLifecycleTracking() throws Exception {
        // Use reflection to create an instance of ThreadLifecycleTracker
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level2.ThreadLifecycleTracker");
        Constructor<?> constructor = clazz.getConstructor();
        Thread tracker = (Thread) constructor.newInstance();

        // Check the initial state using reflection
        Method getStateMethod = Thread.class.getMethod("getState");
        Thread.State initialState = (Thread.State) getStateMethod.invoke(tracker);
        assertEquals(Thread.State.NEW, initialState, "Thread should be in NEW state before start.");

        // Start the thread using reflection
        Method startMethod = Thread.class.getMethod("start");
        startMethod.invoke(tracker);

        // Sleep briefly to ensure the thread has transitioned states
        Thread.sleep(100);

        // Access the lock object using reflection
        Field lockField = clazz.getField("lock");
        Object lock = lockField.get(tracker);

        // Ensure the thread enters the WAITING state
        synchronized (lock) {
            lock.notify();
        }

        // Wait for the thread to complete using reflection
        Method joinMethod = Thread.class.getMethod("join");
        joinMethod.invoke(tracker);

        // Check the final state using reflection
        Thread.State finalState = (Thread.State) getStateMethod.invoke(tracker);
        assertEquals(Thread.State.TERMINATED, finalState, "Thread should be in TERMINATED state.");
    }

    @Test
    public void testThreadStateDuringTimedWaiting() throws Exception {
        // Use reflection to create an instance of ThreadLifecycleTracker
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level2.ThreadLifecycleTracker");
        Constructor<?> constructor = clazz.getConstructor();
        Thread tracker = (Thread) constructor.newInstance();

        // Start the thread using reflection
        Method startMethod = Thread.class.getMethod("start");
        startMethod.invoke(tracker);

        // Sleep briefly to ensure the thread reaches the TIMED_WAITING state
        Thread.sleep(600); // This should allow enough time for the thread to enter TIMED_WAITING state

        // Check the state during sleep using reflection
        Method getStateMethod = Thread.class.getMethod("getState");
        Thread.State currentState = (Thread.State) getStateMethod.invoke(tracker);
        assertEquals(Thread.State.TIMED_WAITING, currentState, "Thread should be in TIMED_WAITING state.");

        // Wait for the thread to complete using reflection
        Method joinMethod = Thread.class.getMethod("join");
        joinMethod.invoke(tracker);

        // Check the final state using reflection
        Thread.State finalState = (Thread.State) getStateMethod.invoke(tracker);
        assertEquals(Thread.State.TERMINATED, finalState, "Thread should be in TERMINATED state.");
    }

    @Test
    public void testThreadStateBeforeStart() throws Exception {
        // Use reflection to create an instance of ThreadLifecycleTracker
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level2.ThreadLifecycleTracker");
        Constructor<?> constructor = clazz.getConstructor();
        Thread tracker = (Thread) constructor.newInstance();

        // Check the initial state using reflection
        Method getStateMethod = Thread.class.getMethod("getState");
        Thread.State initialState = (Thread.State) getStateMethod.invoke(tracker);
        assertEquals(Thread.State.NEW, initialState, "Thread should be in NEW state before start.");

        // Start the thread using reflection
        Method startMethod = Thread.class.getMethod("start");
        startMethod.invoke(tracker);
    }
}
