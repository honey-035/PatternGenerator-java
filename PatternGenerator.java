import java.util.Scanner;

public class PatternGenerator {
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); 
                System.out.flush();
                for (int i = 0; i < 50; ++i) System.out.println(); 
            }
        } catch (final Exception e) {
              for (int i = 0; i < 50; ++i) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        clearConsole();
        while (true) {
            System.out.println("\n=== Pattern Generator ===");
            
            System.out.println("Select a Category:");
            System.out.println("1. Easy Patterns");
            System.out.println("2. Medium Patterns");
            System.out.println("3. Hard Patterns");
            System.out.println("0. Exit Application");
            System.out.print("Enter your choice (0-3): ");
            
            int category;
            try {
                category = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                System.out.println("Press Enter to continue...");
                sc.nextLine();                
                continue;
            }
            
            if (category == 0) {
                System.out.println("\nThank you for using the Pattern Generator! Goodbye.");
                break;
            }
            
            int minPattern = 0;
            int maxPattern = 0;

            clearConsole();
            switch (category) {
                case 1:
                    System.out.println("\n--- EASY Patterns ---");
                    System.out.println(" 1. Right Triangle\t\t 2. Inverted Triangle");
                    System.out.println(" 3. Square\t\t\t 4. Left Triangle");
                    System.out.println(" 5. Pyramid\t\t\t 6. Number Triangle");
                    System.out.println(" 7. Floyd's Triangle\t\t 8. Increasing Numbers");
                    System.out.println(" 9. Decreasing Numbers\t\t10. Hollow Square");
                    minPattern = 1;
                    maxPattern = 10;
                    break;
                case 2:
                    System.out.println("\n--- MEDIUM Patterns ---");
                    System.out.println("11. Diamond\t\t\t12. Butterfly");
                    System.out.println("13. Pascal Triangle\t\t14. Palindrome Number");
                    System.out.println("15. Zig Zag\t\t\t16. Hourglass");
                    System.out.println("17. Right Pascal Triangle\t18. Hollow Pyramid");
                    System.out.println("19. Hollow Diamond\t\t20. Number Pyramid");
                    minPattern = 11;
                    maxPattern = 20;
                    break;
                case 3:
                    System.out.println("\n--- HARD Patterns ---");
                    System.out.println("21. 0-1 Triangle\t\t22. X Pattern");
                    System.out.println("23. Numeric Diamond\t\t24. Concentric Square");
                    System.out.println("25. Hollow Butterfly\t\t26. Double Pyramid");
                    System.out.println("27. Alphabet Pyramid\t\t28. Palindrome Alphabet");
                    System.out.println("29. Snake Pattern\t\t30. Star Cross");
                    minPattern = 21;
                    maxPattern = 30;
                    break;
                default:
                    System.out.println("Invalid category choice. Please enter a number between 0 and 3.");
                    System.out.println("Press Enter to continue...");
                    sc.nextLine();
                    continue;
            }
            
            System.out.print("\nChoose a pattern number (" + minPattern + " - " + maxPattern + "): ");
            int pattern;
            try {
                pattern = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                System.out.println("Press Enter to continue...");
                sc.nextLine();
                continue;
            }
            
              if (pattern < minPattern || pattern > maxPattern) {
                System.out.println("Invalid pattern number for the selected category. Please choose a number between " + minPattern + " and " + maxPattern + ".");
                System.out.println("Press Enter to continue...");
                sc.nextLine(); 
                continue;
            }

            System.out.print("Enter the number of rows: ");
            int n;
            try {
                n = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                System.out.println("Press Enter to continue...");
                sc.nextLine();
                continue;
            }
            
            if (n <= 0) {
                System.out.println("Number of rows must be a positive integer.");
                System.out.println("Press Enter to continue...");
                sc.nextLine();
                continue;
            }

            clearConsole();
            System.out.println("\n--- Pattern Output (Rows: " + n + ") ---\n");

            switch (pattern) {
                // Easy
                case 1: // Right Triangle
                    for (int i = 1; i <= n; i++) System.out.println("* ".repeat(i));
                    break;

                case 2: // Inverted Triangle
                    for (int i = n; i >= 1; i--) System.out.println("* ".repeat(i));
                    break;

                case 3: // Square
                    for (int i = 1; i <= n; i++) System.out.println("* ".repeat(n));
                    break;

                case 4: // Left Triangle
                    for (int i = 1; i <= n; i++) {
                        System.out.print("  ".repeat(n - i));
                        System.out.println("* ".repeat(i));
                    }
                    break;

                case 5: // Pyramid
                    for (int i = 1; i <= n; i++) {
                        System.out.print(" ".repeat(n - i));
                        System.out.println("*".repeat(2 * i - 1));
                    }
                    break;

                case 6: // Number Triangle
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= i; j++) System.out.print(j + " ");
                        System.out.println();
                    }
                    break;

                case 7: // Floyd's Triangle
                    int currentFloydNum = 1;
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= i; j++) System.out.print(currentFloydNum++ + " ");
                        System.out.println();
                    }
                    break;

                case 8: // Increasing Numbers
                    for (int i = 1; i <= n; i++) System.out.println((i + " ").repeat(i));
                    break;

                case 9: // Decreasing Numbers
                    for (int i = n; i >= 1; i--) System.out.println((i + " ").repeat(i));
                    break;

                case 10: // Hollow Square
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (i == 1 || i == n || j == 1 || j == n) System.out.print("* ");
                            else System.out.print("  ");
                        }
                        System.out.println();
                    }
                    break;

                // Medium
                case 11: // Diamond
                    for (int i = 1; i <= n; i++) {
                        System.out.print(" ".repeat(n - i));
                        System.out.println("*".repeat(2 * i - 1));
                    }
                    for (int i = n - 1; i >= 1; i--) {
                        System.out.print(" ".repeat(n - i));
                        System.out.println("*".repeat(2 * i - 1));
                    }
                    break;

                case 12: // Butterfly
                    for (int i = 1; i <= n; i++) {
                        System.out.print("*".repeat(i));
                        System.out.print(" ".repeat(2 * (n - i)));
                        System.out.println("*".repeat(i));
                    }
                    for (int i = n; i >= 1; i--) {
                        System.out.print("*".repeat(i));
                        System.out.print(" ".repeat(2 * (n - i)));
                        System.out.println("*".repeat(i));
                    }
                    break;

                case 13: // Pascal Triangle
                    for (int i = 0; i < n; i++) {
                        int val = 1;
                        for (int j = 0; j <= i; j++) {
                            System.out.print(val + " ");
                            val = val * (i - j) / (j + 1);
                        }
                        System.out.println();
                    }
                    break;

                case 14: // Palindrome Number
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n - i; j++) System.out.print(" ");
                        for (int j = i; j >= 1; j--) System.out.print(j);
                        for (int j = 2; j <= i; j++) System.out.print(j);
                        System.out.println();
                    }
                    break;

                case 15: // Zig Zag
                    for (int i = 1; i <= 3; i++) { 
                        for (int j = 1; j <= n; j++) {
                            if ((i + j) % 4 == 0 || (i == 2 && j % 4 == 0))
                                System.out.print("* ");
                            else
                                System.out.print("  ");
                        }
                        System.out.println();
                    }
                    break;

                case 16: // Hourglass
                    for (int i = n; i >= 1; i--) {
                        System.out.print(" ".repeat(n - i));
                        System.out.println("*".repeat(2 * i - 1));
                    }
                    for (int i = 2; i <= n; i++) {
                        System.out.print(" ".repeat(n - i));
                        System.out.println("*".repeat(2 * i - 1));
                    }
                    break;

                case 17: // Right Pascal Triangle
                    for (int i = 1; i <= n; i++) {
                        System.out.println("* ".repeat(i));
                    }
                    for (int i = n - 1; i >= 1; i--) {
                        System.out.println("* ".repeat(i));
                    }
                    break;

                case 18: // Hollow Pyramid 
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n - i; j++) System.out.print(" ");
                        for (int j = 1; j <= (2 * i - 1); j++) {
                            // Print star if it's the first/last char of the row OR it's the last row
                            if (j == 1 || j == (2 * i - 1) || i == n) System.out.print("*");
                            else System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;

                case 19: // Hollow Diamond
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n - i; j++) System.out.print(" ");
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            if (j == 1 || j == 2 * i - 1) System.out.print("*");
                            else System.out.print(" ");
                        }
                        System.out.println();
                    }
                    for (int i = n - 1; i >= 1; i--) {
                        for (int j = 1; j <= n - i; j++) System.out.print(" ");
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            if (j == 1 || j == 2 * i - 1) System.out.print("*");
                            else System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;

                case 20: // Number Pyramid
                    for (int i = 1; i <= n; i++) {
                        System.out.print(" ".repeat(n - i));
                        for (int j = 1; j <= i; j++) System.out.print(j);
                        for (int j = i - 1; j >= 1; j--) System.out.print(j);
                        System.out.println();
                    }
                    break;

                // Hard
                case 21: // 0-1 Triangle
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print((i + j) % 2 == 0 ? "1 " : "0 ");
                        }
                        System.out.println();
                    }
                    break;

                case 22: // X Pattern
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (j == i || j == (n - i + 1)) System.out.print("*");
                            else System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;

                case 23: // Numeric Diamond
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n - i; j++) System.out.print(" ");
                        for (int j = 1; j <= i; j++) System.out.print(j);
                        for (int j = i - 1; j >= 1; j--) System.out.print(j);
                        System.out.println();
                    }
                    for (int i = n - 1; i >= 1; i--) {
                        for (int j = 1; j <= n - i; j++) System.out.print(" ");
                        for (int j = 1; j <= i; j++) System.out.print(j);
                        for (int j = i - 1; j >= 1; j--) System.out.print(j);
                        System.out.println();
                    }
                    break;

                case 24: // Concentric Square
                    for (int i = 0; i < 2 * n - 1; i++) {
                        for (int j = 0; j < 2 * n - 1; j++) {
                            int val = Math.min(Math.min(i, j), Math.min(2 * n - 2 - i, 2 * n - 2 - j));
                            System.out.print((n - val) + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 25: // Hollow Butterfly (Refined)
                
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print((j == 1 || j == i) ? "*" : " ");
                        }
                        for (int j = 1; j <= 2 * (n - i); j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print((j == 1 || j == i) ? "*" : " ");
                        }
                        System.out.println();
                    }
                    for (int i = n; i >= 1; i--) {

                        for (int j = 1; j <= i; j++) {
                            System.out.print((j == 1 || j == i) ? "*" : " ");
                        }
                        for (int j = 1; j <= 2 * (n - i); j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print((j == 1 || j == i) ? "*" : " ");
                        }
                        System.out.println();
                    }
                    break;

                case 26: // Double Pyramid
                    for (int i = 1; i <= n; i++) {
                        System.out.print(" ".repeat(n - i));
                        System.out.print("*".repeat(i));
                        System.out.print(" ".repeat(2 * (n - i)));
                        System.out.println("*".repeat(i));
                    }
                    break;

                case 27: // Alphabet Pyramid
                    for (int i = 1; i <= n; i++) {
                        char ch = 'A';
                        for (int j = 1; j <= i; j++)
                            System.out.print(ch++ + " ");
                        System.out.println();
                    }
                    break;

                case 28: // Palindrome Alphabet (Refined)
                    for (int i = 1; i <= n; i++) {
                        for (int j = i; j >= 1; j--) System.out.print((char)('A' + j - 1));
                        for (int j = 2; j <= i; j++) System.out.print((char)('A' + j - 1));
                        System.out.println();
                    }
                    break;

                case 29: // Snake Pattern 
                    int currentNum = 1;
                    for (int i = 1; i <= n; i++) {
                        if (i % 2 != 0) { 
                            for (int j = 1; j <= n; j++) {
                                System.out.print(String.format("%-3d", currentNum++));
                            }
                        } else { 
                            currentNum += n - 1; 
                            for (int j = 1; j <= n; j++) {
                                System.out.print(String.format("%-3d", currentNum--));
                            }
                            currentNum += n + 1;
                        }
                        System.out.println();
                    }
                    break;

                case 30: // Star Cross
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (i == j || j == n - i + 1) System.out.print("* ");
                            else System.out.print("  ");
                        }
                        System.out.println();
                    }
                    break;
            }

            System.out.print("\nPress 1 to generate another pattern, 0 to exit: ");
            int again;
            try {
                again = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1 or 0.");
                sc.nextLine();
                System.out.println("Press Enter to continue...");
                sc.nextLine();
                continue;
            }
            if (again != 1) {
                System.out.println("Goodbye!");
                break;
            }
        }

        sc.close();
    }
}
