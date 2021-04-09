package org.csystem.app.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class IsPrimeTestRunner {
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(IsPrimeTestCase.class);

        for (Failure failure : result.getFailures())
            System.out.println(failure.toString());

        System.out.printf("Number of failures:%d%n", result.getFailureCount());
        System.out.println(result.wasSuccessful() ? "Success": "Fail");
    }
}
