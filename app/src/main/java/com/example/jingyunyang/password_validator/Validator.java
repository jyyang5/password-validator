package com.example.jingyunyang.password_validator;

/**
 * Created by JingyunYang on 2018/2/9.
 */

public class Validator {
    // get a rule array with flag the rule is true or false
    static int[] getArrary(String inputPassword){
        int correctRuleArray[] = {0, 0};                     // array storing whether rule is correct
        int passedRules = 0;
        if (!inputPassword.equals( "password"))               // rule 1: check if password is "password
            correctRuleArray[0] = 1;
        if(inputPassword.length() >= 8)                         //rule 2: check if length of password >= 8
            correctRuleArray[1] = 1;
        return correctRuleArray;
    }
    // count the correct rules
    static int validate(int[] array){
        int count = 0;
        for(int i=0; i< array.length;i++)
            count += array[i];
        return count;
    }


    }
