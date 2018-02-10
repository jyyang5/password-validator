package com.example.jingyunyang.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JingyunYang on 2018/2/9.
 */

public class JUnitTest {
    static Validator validator;
    @BeforeClass
    public static void init()
    {
        validator = new Validator();
    }

    //test for each rules
    @Test
    public void r1IsCorrect()
    {
        //test if "password"
        assertEquals(validator.getArrary("password")[0],0);
        assertEquals(validator.getArrary("passwor1")[0],1);
        assertEquals(validator.getArrary("12222222")[0],1);
        assertEquals(validator.getArrary("_+{}{}:><")[0],1);
        assertEquals(validator.getArrary("ASARZCASDA")[0],1);

    }

    @Test
    public void r2IsCorrect()
    {
        //if length >= 8
        assertEquals(validator.getArrary("passwor")[1],0);
        assertEquals(validator.getArrary("passwordd")[1],1);
        assertEquals(validator.getArrary("12222222")[1],1);
        assertEquals(validator.getArrary("_+{}{}:><")[1],1);
        assertEquals(validator.getArrary("ASARZCA")[1],0);


    }

    @Test
    public void r3IsCorrect()
    {
        //if has a uppercase letter
        assertEquals(validator.getArrary("Password")[2],1);
        assertEquals(validator.getArrary("password")[2],0);
        assertEquals(validator.getArrary("ASARZCA")[2],1);
        assertEquals(validator.getArrary("_+{}{}:><")[2],0);
        assertEquals(validator.getArrary("12222222")[2],0);


    }
    @Test
    public void r4IsCorrect()
    {
        //if has a lowercase letter
        assertEquals(validator.getArrary("password")[3],1);
        assertEquals(validator.getArrary("PASSWORD")[3],0);
        assertEquals(validator.getArrary("12222222")[3],0);
        assertEquals(validator.getArrary("_+{}{}:><")[3],0);


    }
    @Test
    public void r5IsCorrect()
    {
        //if has a digit
        assertEquals(validator.getArrary("pas1s4od")[4],1);
        assertEquals(validator.getArrary("passwod")[4],0);
        assertEquals(validator.getArrary("12222222")[4],1);
        assertEquals(validator.getArrary("_+{}{}:><")[4],0);
        assertEquals(validator.getArrary("PASSWORD")[4],0);

    }


    // test for sum of rules
    @Test
    public void r6IsCorrect()
    {
        assertEquals(validator.validate(validator.getArrary("password")),2);
        assertEquals(validator.validate(validator.getArrary("Abcd1234")),5);
        assertEquals(validator.validate(validator.getArrary("ABCD1234")),4);
        assertEquals(validator.validate(validator.getArrary("ABCD124")),3);
        assertEquals(validator.validate(validator.getArrary("1242312")),2);
        assertEquals(validator.validate(validator.getArrary("122")),2);
        assertEquals(validator.validate(validator.getArrary(":>")),1);


    }
}
