// Name of project; Ashesi premier league lab1 
// Author ; maxwell nkrumah
// Date created; 22/09/2025
//Purpose; This lab teaches basic Java skills by building a player selection program. You’ll practice: Reading input, Converting units, Using operators (++ and --), Writing conditions (if-else, switch), Making decisions (nested if, ternary), Printing a player report  

import java.util.Scanner;

public class PlayerSelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for converting height and weight
        final double POUND_TO_KG = 0.45359237;
        final int METER_TO_CM = 100;

        // 1. Accept player details from keyboard
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter height (in meters, e.g., 1.75): ");
        double heightMeters = scanner.nextDouble();

        System.out.print("Enter weight (in pounds): ");
        double weightPounds = scanner.nextDouble();

        System.out.print("Enter jersey number: ");
        int jerseyNumber = scanner.nextInt();

        // 2. Convert height to centimeters and weight to kilograms and round weight
        int heightCm = (int) (heightMeters * METER_TO_CM);
        double weightKgExact = weightPounds * POUND_TO_KG;
        int weightKg = (int) weightKgExact; // cast to int, truncates decimal part

        // 3. Increment and decrement simulation
        System.out.println("\nCurrent age: " + age);
        age++; // increase age by 1 (next season)
        System.out.println("New age after increment: " + age);

        System.out.println("Current jersey number: " + jerseyNumber);
        jerseyNumber--; // decrease jersey number by 1 due to penalty
        System.out.println("New jersey number after penalty: " + jerseyNumber);

        // 4. Eligibility checks
        boolean isEligible = (age >= 18) && (age <= 35) && (weightKg < 90);
        if (isEligible) {
            System.out.println("Eligible");
        } else {
            System.out.println("Not Eligible");
        }

        // Check if underage or overweight
        if ((age < 18) || (weightKg >= 90)) {
            System.out.println("Player has a problem (either too young or too heavy)");
        }

        // NOT operator on eligibility
        if (!isEligible) {
            System.out.println("Not Eligible (using NOT operator)");
        }

        // 5. Categorize player by age
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }
        System.out.println("Category: " + category);

        // 6. Determine position using switch with breaks
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Player position not known";
        }
        System.out.println("Position: " + position);

        // 7. Demonstrate unwanted fall-through (Part A)
        System.out.println("\nDemonstrating unwanted fall-through (Part A):");
        switch (jerseyNumber) {
            case 2:
                System.out.println("Case 2: Defender");
            case 6:
                System.out.println("Case 6: Midfielder");
            case 7:
                System.out.println("Case 7: Winger");
                break;
            default:
                System.out.println("Default case: Player position not known");
        }

        // 7. Part B - Grouped cases properly
        System.out.println("\nDemonstrating grouped cases (Part B):");
        switch (jerseyNumber) {
            case 1:
                System.out.println("Goalkeeper");
                break;
            case 2:
            case 5:
                System.out.println("Defender");
                break;
            case 6:
            case 8:
                System.out.println("Midfielder");
                break;
            case 7:
            case 11:
                System.out.println("Winger");
                break;
            case 9:
                System.out.println("Striker");
                break;
            case 10:
                System.out.println("Playmaker");
                break;
            default:
                System.out.println("Player position not known");
        }

        // 8. Nested ifs for starting lineup selection
        String lineupDecision;
        if ("Prime Player".equals(category)) {
            if (weightKg < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench";
            }
        } else {
            lineupDecision = "Bench";
        }
        System.out.println("Lineup Decision: " + lineupDecision);

        // 9. Ternary operator for final decision based on eligibility
        String finalDecision = isEligible ? "Play" : "Rest";

        // 10. Player Report
        System.out.println("\n----- Player Report -----");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightCm + " cm");
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Jersey: " + jerseyNumber);
        System.out.println("Position: " + position);

        // Attacker jersey number: attacker numbers are usually 7, 9, 10, 11
        boolean isAttacker = (jerseyNumber == 7 || jerseyNumber == 9 || jerseyNumber == 10 || jerseyNumber == 11);
        System.out.println("Attacker jersey: " + (isAttacker ? "Yes" : "No"));

        System.out.println("Eligibility: " + (isEligible ? "Eligible" : "Not Eligible"));
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        scanner.close();
    }
}