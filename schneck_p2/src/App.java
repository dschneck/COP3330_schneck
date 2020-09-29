import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while(moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);
            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput() {
        boolean more = false;
        System.out.println("Is there more input (Y or N): ");
        
        char answer = scanner.next().charAt(0);

        if (answer == 'Y') more = true;
        if (answer == 'N') more = false;

        return more;
    }

    private static double getUserHeight() {
        double height = -1.0;
        System.out.println("Please enter your height in inches...");

        while (height < 0) {
            height = scanner.nextInt();
            scanner.nextLine();

            if (height < 0) System.out.println("Your height must be greater than 0...");
        }

        return height;
    }

    private static double getUserWeight() {
        double weight = -1.0;
        System.out.println("Please enter your weight in pounds...");

        while (weight < 0) {
            weight = scanner.nextInt();
            
            if (weight < 0) System.out.println("Your weight must be greater than 0...");
        }

        return weight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println(bmi.bmiScore);
        System.out.println(bmi.bmiScore);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> allData) {
        double average = 0.0;

        for (int i = 0; i < allData.size(); i++) {
            average += allData.get(i).bmiScore;
        }

        average = average / allData.size();
        System.out.println("The average BMI score from the data was: " + average);
    }
}