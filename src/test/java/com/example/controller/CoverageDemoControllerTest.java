package com.example.controller;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jonatan Ivanov
 */
public class CoverageDemoControllerTest {
    @Test
    public void helloTest() {
        Assert.assertEquals("Oh, Hai!", new CoverageDemoController().hello());
    }
}
