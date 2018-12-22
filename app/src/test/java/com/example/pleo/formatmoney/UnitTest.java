package com.example.pleo.formatmoney;

import com.example.pleo.formatmoney.utilities.NumbersGenericUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class UnitTest {

    //javadocs Double.html#valueOf-java.lang.String
    private boolean isAParsableNumber(String input) {
        final String Digits = "(\\p{Digit}+)";
        final String HexDigits = "(\\p{XDigit}+)";
        final String Exp = "[eE][+-]?" + Digits;
        final String fpRegex = (
                "[\\x00-\\x20]*" + "[+-]?(" + "NaN|" + "Infinity|"
                        + "(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|"
                        + "(\\.(" + Digits + ")(" + Exp + ")?)|" + "((" + "(0[xX]"
                        + HexDigits + "(\\.)?)|" + "(0[xX]" + HexDigits + "?(\\.)"
                        + HexDigits + ")" + ")[pP][+-]?" + Digits + "))" + "[fFdD]?))"
                        + "[\\x00-\\x20]*");

        return Pattern.matches(Digits, input) ? true : false;
    }

    private String getAFormattedDouble() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String aDouble = decimalFormat.format(Double.MAX_VALUE);
        return aDouble.replaceAll(",", "");
    }

    private String getARandomDouble() {
        double leftLimit = -Double.MAX_VALUE;
        double rightLimit = Double.MAX_VALUE;
        double generatedDouble = new RandomDataGenerator().nextUniform(leftLimit, rightLimit);
        return String.valueOf(generatedDouble);
    }

    private String getARandomInt() {
        int leftLimit = -Integer.MAX_VALUE;
        int rightLimit = Integer.MAX_VALUE;
        int generatedInteger = new RandomDataGenerator().nextInt(leftLimit, rightLimit);
        return String.valueOf(generatedInteger);
    }

    private String aDouble = getAFormattedDouble();
    private String biggerThanADouble = "1" + aDouble;
    private String zero = "0";
    private String aNegativeDouble = "-" + aDouble;
    private String biggerThanANegativeDouble = "-1" + aDouble;
    private String message = "The maximum amount allowed is";

    @Test
    public void boundaryValueAnalysisAndEquivalencePartitioningTest() {

        assertThat(NumbersGenericUtils.format(Double.parseDouble(
                aDouble)), not(containsString(message)));

        assertThat(NumbersGenericUtils.format(Double.parseDouble(
                biggerThanADouble)), (containsString(message)));

        assertThat(NumbersGenericUtils.format(Double.parseDouble(
                zero)), not(containsString(message)));

        assertThat(NumbersGenericUtils.format(Double.parseDouble(
                aNegativeDouble)), not(containsString(message)));

        assertThat(NumbersGenericUtils.format(Double.parseDouble(
                biggerThanANegativeDouble)), (containsString(message)));

        int counter = 1;
        while (counter <= 5){
            assertThat(NumbersGenericUtils.format(Double.parseDouble(getARandomInt())),
                    not(containsString(message)));
            counter++;
        }
        int secondCounter = 1;
        while (secondCounter <= 5){
            assertThat(NumbersGenericUtils.format(Double.parseDouble(getARandomDouble())),
                    not(containsString(message)));
            secondCounter++;
        }
    }

    @Test
    public void fuzzTest() throws FileNotFoundException {
        File file = new File(
                "/Users/salvatop/Documents/FormatMoney/app/src/test/"
                        + "java/com/example/pleo/formatmoney/testdata.csv");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            System.out.print("\n" + "next value is: " + scanner.next() + "\n");

            if (isAParsableNumber(scanner.next())) {
                System.out.print("\n" + "next VALID is: " + scanner.next().trim());
                //System.out.print("\n" + "FORMAT-2: " + NumbersGenericUtils.format(Double.parseDouble(scanner.next().trim() + "\n")));
                System.out.print("\n" + "FORMAT: " + NumbersGenericUtils.format(Double.valueOf(scanner.next().trim() + "\n")));
            }
        }
        scanner.close();
    }

    @Test
    public void mutationTestProgramOne() {

        assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(
                aDouble)), not(containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(
                biggerThanADouble)), (containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(
                zero)), not(containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(
                aNegativeDouble)), not(containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(
                biggerThanANegativeDouble)), (containsString(message)));

        int counter = 1;
        while (counter <= 5){
            assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(getARandomInt())),
                    not(containsString(message)));
            counter++;
        }
        int secondCounter = 1;
        while (secondCounter <= 5){
            assertThat(NumbersGenericUtils.formatMutantOne(Double.parseDouble(getARandomDouble())),
                    not(containsString(message)));
            secondCounter++;
        }
    }

    @Test
    public void mutationTestProgramTwo() {

        assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(
                aDouble)), not(containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(
                biggerThanADouble)), (containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(
                zero)), not(containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(
                aNegativeDouble)), not(containsString(message)));

        assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(
                biggerThanANegativeDouble)), (containsString(message)));

        int counter = 1;
        while (counter <= 5){
            assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(getARandomInt())),
                    not(containsString(message)));
            counter++;
        }
        int secondCounter = 1;
        while (secondCounter <= 5){
            assertThat(NumbersGenericUtils.formatMutantTwo(Double.parseDouble(getARandomDouble())),
                    not(containsString(message)));
            secondCounter++;
        }
    }
}