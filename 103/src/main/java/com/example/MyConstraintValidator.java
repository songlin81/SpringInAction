package com.example;

import com.example.demo.MyConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {

    //String为校验的类型
    @Override
    public void initialize(MyConstraint myConstraint) {
        //init on load
    }

    /**
     * @Description: customize validation
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext validatorContext) {
        if (!(s.equals("Beijing") || s.equals("Shanghai"))) {
            return false;
        }
        return true;
    }
}
