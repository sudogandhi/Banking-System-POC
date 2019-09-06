package com.dbs.banking.poc.bankingdemo.validations.validators;

import com.dbs.banking.poc.bankingdemo.validations.annontations.Mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Mobile, String> {
    private Pattern pattern;
    private Matcher matcher;

    private static final String MOBILE_PATTERN ="[7-9][0-9]{9}";
    @Override
    public void initialize(Mobile constraintAnnotation) {
        pattern = Pattern.compile(MOBILE_PATTERN);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        matcher = pattern.matcher(s);
        return matcher.find() && matcher.group().equals(s);
    }
}
