import java.util.Scanner;

/**
 * @author Josh McKinley mckinlju@mail.uc.edu
 */
public class SafeInput {

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString ="";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while (retString.length() == 0);

        return retString;
    }

    /**
     * Get an integer value from the user with no constraints
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @return an int value provided by the user
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine(); // clear key buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }

    /**
     * Get a double value from the user with no constraints
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @return a double value provided by the user
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine(); // clear key buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }

    /**
     * Get an integer value from the user within a specified inclusive low - high range
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @param low    low value for the range
     * @param high   high value for the range
     * @return an int value provided by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine(); // clear key buffer
                if(retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] not: " + retValue);
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }

    /**
     * Get a double value from the user within a specified inclusive low - high range
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @param low    low value for the range
     * @param high   high value for the range
     * @return an int value provided by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, int low, int high)
    {
        double retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine(); // clear key buffer
                if(retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] not: " + retValue);
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String runAgain = "";
        do
        {
            System.out.print(prompt + ": ");
            runAgain = pipe.nextLine().toLowerCase();
        }while(!runAgain.equals("y") && !runAgain.equals("n"));

        return runAgain.equals("y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        String value = "";
        boolean gotAValue = false;

        do {
            // show the prompt
            System.out.print(prompt + ": ");
            // input the data
            value = pipe.nextLine();
            // test to see if it is correct
            if (value.matches(regExPattern)) {
                // We have a match this String passes!
                gotAValue = true;
            } else {
                System.out.println("\nInvalid input: " + value);
            }

        } while (!gotAValue);

        return value;
    }
}
