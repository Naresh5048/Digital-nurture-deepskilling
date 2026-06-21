package com.cts.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        JUnitExercisesTest.class,
        AdvancedJUnitTestSuite.class,
        SampleSecondTest.class
})
public class AllTests {

}