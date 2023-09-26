package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.PreconditionViolationException;
import org.junitpioneer.jupiter.RetryingTest;

import static org.assertj.core.api.Assumptions.assumeThat;
class AppTest
{
    /**
     * Expected result: Test should be skipped with no Failing Exception
     * Present Result: Test fails with the following exception:
     * {@link PreconditionViolationException }: Illegal state: required test method is not present in the current ExtensionContext
     */
    @Test
    @RetryingTest(maxAttempts = 10, minSuccess = 1, name="[{index}] {displayName}")
    void sampleTestWithFalseAssumption() {
        assumeThat(false).isTrue();
    }

    /**
     * Works well !
     */
    @Test
    @Disabled
    @RetryingTest(maxAttempts = 10, minSuccess = 1, name="[{index}] {displayName}")
    void disabledSampleTestWithFalseAssumption() {
        assumeThat(true).isTrue();
    }

    /**
     * Works well !
     */
    @Test
    @RetryingTest(maxAttempts = 10, minSuccess = 1, name="[{index}] {displayName}")
    void sampleTestWithTrueAssumption() {
        assumeThat(true).isTrue();
    }
}
