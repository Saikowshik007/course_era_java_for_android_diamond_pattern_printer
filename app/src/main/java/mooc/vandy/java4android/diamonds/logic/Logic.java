package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        int n = size;
        int h = n * 2 + 1;
        int w = n * 2 + 2;
        int s = n + 2; //top part left bound
        int k = n + 1;//top part right bound
        int u = -(n + 1) + 3;//bottom part left bound
        int v = w - 2 + n + 1;//bottom part right bound
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {                                                           //to print frame.....
                if ((i == 1 || i == h) && (j == 1 || j == w)) {
                    mOut.print("+");
                } else if ((i == 1 || i == h) && !(j == 1 || j == w)) {
                    mOut.print("-");
                } else if (!(i == 1 || i == h) && (j == 1 || j == w)) {
                    mOut.print("|");
                } else {                                                                             //to print middle line..........
                    if (i == n + 1) {
                        if (j == 2) {
                            mOut.print("<");
                        } else if (j == w - 1) {
                            mOut.print(">");
                        } else {
                            if (i % 2 == 0) {
                                if (j >= 2 && j <= w - 1) mOut.print("=");
                            } else {
                                if (j >= 2 && j <= w - 1) mOut.print("-");
                            }
                        }
                    } else if (i <= n) {                                                            //to print top part..........
                        if (j == s) {
                            mOut.print("/");
                        } else if (j == k) {
                            mOut.print("\\");
                        } else if (j >= 2 && j <= w - 1 && j >= s && j <= k) {
                            if (i % 2 == 0) mOut.print("=");
                            else mOut.print("-");
                        } else mOut.print(" ");
                    } else if (i >= n + 2) {                                                        //to print lower part.......
                        if (j == u) {
                            mOut.print("\\");
                        } else if (j == v) {
                            mOut.print("/");
                        } else if (j >= u && j <= v) {
                            if (i % 2 == 0) mOut.print("=");
                            else mOut.print("-");
                        } else mOut.print(" ");

                    }

                }

            }
            mOut.print("\n");
            s -=1;k +=1;
            u +=1;
            v -=1;
        }
    }
}

