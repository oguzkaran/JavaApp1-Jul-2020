package org.csystem.app.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class IsPrimeNegativeTestRunner {
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(IsPrimeNegativeTestCase.class);

        for (Failure failure : result.getFailures())
            System.out.println(failure.toString());

        System.out.printf("Number of failures:%d%n", result.getFailureCount());
        System.out.println(result.wasSuccessful() ? "Success": "Fail");
    }
}
