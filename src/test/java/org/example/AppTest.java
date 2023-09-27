package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.PreconditionViolationException;
import org.junitpioneer.jupiter.RetryingTest;

import static org.assertj.core.api.Assumptions.assumeThat;
class AppTest
{
    /**
     * Works well !
     */
    @RetryingTest(maxAttempts = 10, minSuccess = 1, name="[{index}] {displayName}")
    void sampleTestWithFalseAssumption() {
        assumeThat(false).isTrue();
    }

    /**
     * Works well !
     */
    @Disabled
    @RetryingTest(maxAttempts = 10, minSuccess = 1, name="[{index}] {displayName}")
    void disabledSampleTestWithFalseAssumption() {
        assumeThat(true).isTrue();
    }

    /**
     * Works well !
     */
    @RetryingTest(maxAttempts = 10, minSuccess = 1, name="[{index}] {displayName}")
    void sampleTestWithTrueAssumption() {
        assumeThat(true).isTrue();
    }
}
