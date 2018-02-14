/**
 * The purpose of this program is to print out the data of all the planets and calculate gravity.
 *
 * @author Briana Berger
 * @version 12/26/17
 */

import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class PlanetGravity
{
    // Calculate the surface gravity.
    public static double calculateGravity(double d, double m)
    {
        return Math.round((((6.67 * Math.pow(10,-11)) * m)/Math.pow((d/2), 2)) * 100.0)/100.0;
    }

    // Print the results.
    public static void printResults(String p[], double d[], double m[], double g[])
    {
        System.out.println();
        System.out.printf("%45s %n","Planetary Data");
        System.out.printf("%10s %20s %20s %20s %n", "Planet", "Diameter (km)", "Mass (kg)", "g (m/s^2)");
        System.out.println("============================================================================");       
        for (int i = 0; i < p.length; i++)
        {
            System.out.printf("%10s %15s %14s %7.2e %19s %n", p[i], d[i], "", m[i], g[i]);
        }
    }

    //Print gravities to a text file.
    public static void gravitiyPrintOut (double g[]) throws IOException
    {
        File fileOutName = new File("SummaryOfGravities.txt");
        PrintWriter outputFile  = new PrintWriter(fileOutName);
        for(int i = 0; i < g.length; i++)
        {
            outputFile.println(g[i]);
        }
        outputFile.close();
    }
    
    // The main method.
    public static void main(String[] args) throws IOException
    {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        double[] diameters = {4880, 12103.6, 12756.3, 6794, 142984, 120536, 51118, 49532};
        double[] masses = {(3.30 * Math.pow(10, 23)), (4.869 * Math.pow(10, 24)), (5.972 * Math.pow(10, 24)), (6.4219 * Math.pow(10, 23)), (1.900 * Math.pow(10, 27)), (5.68 * Math.pow(10, 26)), (8.683 * Math.pow(10, 25)), (1.0247 * Math.pow(10, 26))};
        double[] gravities = new double [8];
        
        for (int i = 0; i < gravities.length; i++)
        {
            gravities[i] = calculateGravity((diameters[i] * 1000), masses[i]);
        }
        
        printResults(planets, diameters, masses, gravities);
        gravitiyPrintOut(gravities);
    }
}
