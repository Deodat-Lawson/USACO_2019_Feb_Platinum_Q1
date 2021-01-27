package USACO;

import java.util.*;
import java.io.*;

public class USACO_2019_Feb_Platinum_Q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowdate.in"));

        int numOfCows = Integer.parseInt(f.readLine());
        double[] allCows = new double[numOfCows];
        double ans = 0;
        for (int i = 0; i < numOfCows; i++) {
            allCows[i] = Double.parseDouble(f.readLine());
            allCows[i] = (allCows[i] / 1000000);
            ans = Math.max(ans, allCows[i]);
        }


        double A = 0;
        double B = 1;
        for (int left = 0, right = 0; left < numOfCows; left++) {
            for (; right < numOfCows && A < 1; right++) {
                A = (A + (allCows[right] / (1 - allCows[right])));
                B = B * (1 - allCows[right]);
            }
            ans = Math.max(ans, A * B);
            A = A - (allCows[left] / (1 - allCows[left]));
            B = B / (1 - allCows[left]);
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdate.out")));
        out.print((int) (ans * 1000000));
        out.close();
        f.close();

    }
}