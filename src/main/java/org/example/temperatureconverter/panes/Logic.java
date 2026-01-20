package org.example.temperatureconverter.panes;

public class Logic {
    private double result = 0;
    private char scale;
    public Logic () {}

    public double calculate(String requestedConversion, double x) {

        switch (requestedConversion) {

            case "fahrenheit->celsius":
                result = fToC(x);
                break;

            case "fahrenheit->kelvin":
                result = fToK(x);
                break;

            case "kelvin->celsius":
                result = kToC(x);
                break;

            case "kelvin->fahrenheit":
                result = kToF(x);
                break;

            case "celsius->fahrenheit":
                result = cToF(x);
                break;

            case "celsius->kelvin":
                result = cToK(x);
                break;

            case "celsius->celsius", "fahrenheit->fahrenheit", "kelvin->kelvin":
                result = Double.NaN;
                break;

            default:
                System.out.println("Unsupported conversion");
        }
        return result;
    }
    public String displayText(String requestedConversion, double x) {
        calculate(requestedConversion, x);
        return Double.toString(result) + scale;
    }
    public double fToC (double f) {
        scale = 'C';
        return 5.0/9.0 * (f - 32.0);
    }

    public double fToK(double f) {
        scale = 'K';
        return 5.0/9.0 * (f - 32.0) + 273.15;
    }

    public double kToC(double k) {
        scale = 'C';
        return k - 273.15;
    }

    public double kToF(double k) {
        scale = 'F';
        return 9.0/5.0 * (k - 273.15) + 32.0;
    }

    public double cToF(double c) {
        scale = 'F';
        return 9.0/5.0 * (c) + 32.0;
    }

    public double cToK(double c) {
        scale = 'K';
        return c + 273.15;
    }

    public char getScale() {
        return scale;
    }
}
