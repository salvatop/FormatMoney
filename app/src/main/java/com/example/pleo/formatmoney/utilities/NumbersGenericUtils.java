package com.example.pleo.formatmoney.utilities;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class NumbersGenericUtils {

    public static String format(double amount) {

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        String exceededSize = "The maximum amount allowed is up to: " + Double.MAX_VALUE + "( or it negative)";
        String output = (amount > Double.MAX_VALUE | amount < -Double.MAX_VALUE) ? exceededSize : "";

        if (!output.equals(exceededSize)) {

            try {
                String formattedAmount = decimalFormat.format(amount);
                output = formattedAmount.replaceAll(",", " ");

            } catch (InputMismatchException i) {
                output = "Only numbers allowed up to" + Double.MAX_VALUE;

            } catch (NoSuchElementException n) {
                output = "You haven't input anything :)";

            } catch (NumberFormatException e) {
                output = "Only numbers allowed up to" + Double.MAX_VALUE;
                }
        }

        return output;
    }



    /*
    TODO: here some mutant programs of format() for mutation testing.
    remove the lines below once testing is finished
     */


    //mutation: if (!output.equals(exceededSize)) -> if (output.equals(exceededSize))
    public static String formatMutantOne(double amount) {

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        String exceededSize = "The maximum amount allowed is up to: " + Double.MAX_VALUE + "( or it negative)";
        String output = (amount > Double.MAX_VALUE | amount < -Double.MAX_VALUE) ? exceededSize : "";

        if (output.equals(exceededSize)) {

            try {
                String formattedAmount = decimalFormat.format(amount);
                output = formattedAmount.replaceAll(",", " ");

            } catch (InputMismatchException e) {
                output = "Only numbers allowed up to" + Double.MAX_VALUE;

            } catch (NoSuchElementException e) {
                output = "You haven't input anything :)";
            }
        }

        return output;
    }

    //mutation: amount > Double.MAX_VALUE -> amount == Double.MAX_VALUE
    public static String formatMutantTwo(double amount) {

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        String exceededSize = "The maximum amount allowed is up to: " + Double.MAX_VALUE + "( or it negative)";
        String output = (amount == Double.MAX_VALUE | amount < -Double.MAX_VALUE) ? exceededSize : "";

        if (!output.equals(exceededSize)) {

            try {
                String formattedAmount = decimalFormat.format(amount);
                output = formattedAmount.replaceAll(",", " ");

            } catch (InputMismatchException e) {
                output = "Only numbers allowed up to" + Double.MAX_VALUE;

            } catch (NoSuchElementException e) {
                output = "You haven't input anything :)";
            }
        }

        return output;
    }
}