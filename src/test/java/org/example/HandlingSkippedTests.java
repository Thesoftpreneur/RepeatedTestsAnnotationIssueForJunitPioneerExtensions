package org.example;

import org.junit.AssumptionViolatedException;
import org.junitpioneer.jupiter.RetryingTest;
import org.opentest4j.TestAbortedException;


public class HandlingSkippedTests {

    /**
     * Works well !
     */
    @RetryingTest(maxAttempts = 7, name = "[{index}] {displayName}")
    void handlingTestAbortedException() {
        throw new TestAbortedException();
    }

    /**
     * Should behave the same way as the {@link #handlingTestAbortedException()}
     * but unfortunately the {@link AssumptionViolatedException} is interpreted the same way as assertion
     */
    @RetryingTest(maxAttempts = 7, name = "[{index}] {displayName}")
    void handlingAssumptionViolatedException() {
        throw new AssumptionViolatedException("assumption is not met");
    }
}
