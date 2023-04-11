package com.jac.thymleaf.SpringMVCProject.testexample;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersTest {

    //https://www.baeldung.com/parameterized-tests-junit-5
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void testOddMethod(int number){
        var actual  = Numbers.isOdd(number);
        assertTrue(actual);
    }
}
