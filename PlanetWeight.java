/**
 * The purpose of this program is to use the user's weight on Earth to calculate their weight on other planets and then display the planet data.
 *
 * @author Briana Berger
 * @version 12/26/17
 */

import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class PlanetWeight
{
    // Calculate the surface gravity.
    public static double calculateWeightOnDifPlanets(double m, double g)
    {
        double weight = Math.round((m * g) * 100.0)/100.0;
        return weight;
    }

    // Print the results.
    public static void printResults(String p[], double g[], double w[])
    {
        System.out.println();
        System.out.printf("%30s %n","My Weight on the Planets");
        System.out.printf("%10s %10s %15s %n", "Planet", "Gravity", "Weight (lbs)");
        System.out.println("=======================================");       
        for (int i = 0; i < p.length; i++)
        {
            System.out.printf("%10s %8s %12s %n", p[i], g[i], w[i]);
        }
    }

    // The main method.
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        File fileInName = new File("SummaryOfGravities.txt");
        Scanner inFile = new Scanner(fileInName);
        
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        double[] weights = new double [8];
        double[] gravities = new double [8];
        
        System.out.println("What is your weight in pounds?");
        double weightOnEarth = in.nextDouble();
        double mass = Math.round((weightOnEarth/9.79) * 100.0)/100.0;
        
        for (int i = 0; i < planets.length; i++)
        {
            gravities[i] = inFile.nextDouble();
            weights[i] = calculateWeightOnDifPlanets(mass, gravities[i]);
        }
        
        printResults(planets, gravities, weights);
    }
}
