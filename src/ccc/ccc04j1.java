package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc04j1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("The largest square has side length " + (int) Math.sqrt(Integer.parseInt(in.readLine())) + ".");
    }
}