import java.util.Scanner;

public class RestPt5 {
    static int numStaff;
    static int numCustomers;
    static int[][] rating = new int[100][100]; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100];
        Customer[] customers = new Customer[100];
        int menuChoice;

        //Main Menu
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Menu 1 (Employee/Customer data)");
            System.out.println("2. Menu 2 (Other features)");
            System.out.println("0. Quit");

            menuChoice = sc.nextInt();
            switch (menuChoice) {
                case 1:
                    menu1(sc, employees, customers);
                    break;
                case 2:
                    menu2(sc, employees, customers);
                    break;
                case 0:
                    System.out.println("Goodbye! Have a nice day!");
                    return;
                default:
                    System.out.println("Enter a valid number.");
            }
        }
        while (menuChoice != 0);
    }
    //Creates menu 1
    public static void menu1(Scanner sc, Employee[] employees, Customer[] customers) {
        int choice;
        do {
            System.out.println("Menu 1:");
            System.out.println("1. Enter Employee Info");
            System.out.println("2. Enter Customer Info");
            System.out.println("0. Return to Main Menu");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    employeeData(sc, employees);
                    break;
                case 2:
                    customerData(sc, customers, employees, rating);
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Enter a valid number.");
            }
            
            } while (choice != 0);
            }
    
    
        //input for employee data
    public static void employeeData(Scanner sc, Employee[] employees) {
        
        System.out.println("Enter the number of staff members: ");
        numStaff = sc.nextInt(); 
        if (numStaff > 100) { //if user enter more than 100, it stops the program
            System.out.println("Cannot have more than 100 staff members.");
            return;
        }
        sc.nextLine();

        for (int i = 0; i < numStaff; i++) {
            System.out.println("Employee #" + (i + 1));
            System.out.print("First Name: ");
            String firstName = sc.nextLine();
            System.out.print("Last Name: ");
            String lastName = sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            System.out.print("Year Hired: ");
            int yearHired = sc.nextInt();
            sc.nextLine();
            System.out.print("Position: ");
            String position = sc.nextLine();
            System.out.print("Wage: ");
            double wage = sc.nextDouble();
            System.out.print("Weekly Hours: ");
            int hours = sc.nextInt();
            sc.nextLine();

            employees[i] = new Employee(firstName, lastName, phone, yearHired, position, wage, hours);
        }
    }
    
    //input for customer data
    public static void customerData(Scanner sc, Customer[] customers, Employee[] employees, int[][] rating) {
        System.out.println("Enter the number of customers: ");
        numCustomers = sc.nextInt(); 
        if (numCustomers > 100) { //if user enter more than 100, it stops the program
            System.out.println("Cannot have more than 100 customers.");
            return;
        }
        sc.nextLine();

            for (int i=0; i <numCustomers; i++) {
            System.out.println("Enter the details for Customer" + (i + 1) + ":");
            System.out.print("First Name: ");
            String custFirstNames = sc.next();
            System.out.print("Last Name: ");
            String custLastNames = sc.next();
            System.out.print("Day: ");
            String day = sc.next().toUpperCase();
            System.out.print("Time (HH:MMpm/am): ");
            String time = sc.next().toUpperCase();
            System.out.print("Phone number: ");
            String custPhoneNumber = sc.next();
            System.out.print("Order Type (Pick up/Delivery): ");
            String orderType = sc.next();
            System.out.print("Online Order (Yes/No): ");
            String onlineOrder = sc.next();
            System.out.println("Enter The Order Details");
            System.out.print("Ticket Number: ");
            int ticketNumber = sc.nextInt();
            System.out.println("Buy 5 pizzas get 1 Pizza FREE!");
            System.out.print("Number of pizzas ordered: ");
            int pizzaNumber = sc.nextInt();
            if (pizzaNumber >= 5) {
                System.out.println("You earned a free pizza now!");;
            }
            System.out.print("Pizza Type (PLain/Meat): ");
            String pizzaType = sc.next();
            System.out.print("Pizza Size (Small/Large): ");
            String  pizzaSize = sc.next();
            System.out.print("Pizza Price (Small/Large): ");
            double pizzaPrice = sc.nextDouble();
            System.out.print("Cutting Style (Square/Regular): ");
            String cuttingStyle = sc.next();
            System.out.print("Drinks ($3 each): ");
            int drinks = sc.nextInt();
            System.out.print("Tip (10, 15, 20): ");
            double tip = sc.nextDouble();
            System.out.print("Allergies (Yes/No): ");
            String allergies = sc.next();

            customers[i] = new Customer(custFirstNames, custLastNames, custPhoneNumber, orderType, onlineOrder, ticketNumber,
                    pizzaNumber, pizzaType, pizzaSize, pizzaPrice, cuttingStyle, drinks, allergies, tip);

            //Gets the ratings from each customer for the employees
            for (int j = 0; j < numStaff; j++) {
                System.out.print("Enter rating for Employee #" + (j + 1) + ": ");
                int ratingValue = sc.nextInt();
                if (ratingValue >= 1 && ratingValue <= 5) {
                    rating[i][j] = ratingValue;
                } else {
                    System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                    j--; 
                }
            }
        }
    }       //Calculates the average rating for each employee
            public static void displayRating(int[][] rating, int numCustomers, int numStaff) {
                System.out.println("Average ratings for each employee:");
                 double[] averageRatings = new double[numStaff];
            for (int i = 0; i < numStaff; i++) {
                 int totalRating = 0;
            for (int j = 0; j < numCustomers; j++) {
                totalRating += rating[j][i];
            }
            averageRatings[i] = totalRating / (double) numCustomers;
            System.out.println("Employee #" + (i + 1) + ": " + averageRatings[i]);
                }
}           
            //Creates menu 2
             public static void menu2(Scanner sc, Employee[] employees, Customer[] customers) {
                while (true) {
                System.out.println("Menu 2:");
                System.out.println("1. To display the years of experience for each Employee in 2024\n" +
                    "2. To display the weekly pay for each Employee\n" +
                    "3. To display the annual salary for each Employee\n" +
                    "4. To display the annual tax and net income for each Employee\n" +
                    "5. To display the rating average for each Employee\n" +
                    "6. To display for each order the total before tax\n" +
                    "7. To display for each order the total after tax\n" +
                    "8. To display the tip by the chosen percentage\n" +
                    "9. To display the total of the order including tax+tip\n" +
                    "10. To display the discount (if any) of each order\n" +
                    "11. To display the average of all orders and tips average\n" +
                    "12. To display which employees have the 'Manager' job title.\n" +
                    "0. Return to Main Menu");
            int choice = sc.nextInt();
            
            //depending on the user's choice, it will calculate/display the information
            switch (choice) {
                //Calculates the years of experience for each employee
                case 1:
                    for (Employee emp : employees) {
                        if (emp != null) {
                            int yearExperience = 2024 - emp.getYearHired();
                            System.out.println("Years of Experience for " + emp.getFirstName() + " " +
                             emp.getLastName() + ": " + yearExperience);
                }
            }
            break;
                //Calculates the weekly pay for each employee
                case 2:
                    for (Employee emp : employees) {
                        if (emp != null) {
                            double weeklyPay = emp.getWage() * emp.getWeeklyHours();
                            System.out.println("Weekly Pay for " + emp.getFirstName() + " " + emp.getLastName() 
                            + ": $" + weeklyPay);
                        }
                    }
                    break;

                //Calculates the annual salary for each employee
                case 3:
                    for (Employee emp : employees) {
                        if (emp != null) {
                            double annualSalary = emp.getWage() * emp.getWeeklyHours() * 52; //assuming there are 52 weeks in a year
                            System.out.println("Annual Salary for " + emp.getFirstName() + " " + emp.getLastName() 
                            + ": $" + annualSalary);
                        }
                    }
                    break;
                //Calculates the annual tax and net income for each employee
                case 4:
                    for (Employee emp : employees) {
                        if (emp != null) {
                            double annualSalary = emp.getWage() * emp.getWeeklyHours() * 52;
                            double tax = annualSalary * 0.05;
                            double netIncome = annualSalary - tax;
                            System.out.println("Tax for " + emp.getFirstName() + " " + emp.getLastName() 
                            + ": $" + tax + ", Net Income: $" + netIncome);
                        }
                    }
                    break;
                
                //Displays the average rating for each employee
                case 5:
                    displayRating(rating, numCustomers, numStaff);
                    break;

                    //Calculates the total before tax for each order
                    case 6:
                    for (Customer cust : customers) {
                        if (cust != null) {
                            double totalBeforeTax = cust.getPizzaPrice() * cust.getPizzaNumber() + (cust.getDrinks() * 3);
                            System.out.println("Total before tax for " + cust.getFirstName() + " " + cust.getLastName() 
                            + ": $" + totalBeforeTax);
                        }
                    }
                    break;
                
                //Calculates the total after tax for each order
                case 7:
                    for (Customer cust : customers) {
                        if (cust != null) {
                            double totalBeforeTax = cust.getPizzaPrice() * cust.getPizzaNumber() + (cust.getDrinks() * 3);
                            double tax = totalBeforeTax * 0.0625;
                            double totalAfterTax = totalBeforeTax + tax;
                            System.out.println("Total after tax for " + cust.getFirstName() + " " + cust.getLastName() 
                            + ": $" + totalAfterTax);
                        }
                    }
                    break;

                //Calculates the tip for each order
                case 8:
                    for (Customer cust : customers) {
                    if (cust != null) {
                    double tipPercentage = cust.getTip();  
                    double totalBeforeTax = cust.getPizzaPrice() * cust.getPizzaNumber() + (cust.getDrinks() * 3);
                    double tip = totalBeforeTax * (tipPercentage / 100);  
                    System.out.println("Tip for " + cust.getFirstName() + " " + cust.getLastName() 
                            + ": $" + tip);
                        }
                    }
                    break;

                //Calculates the order total
                case 9:
                    for (Customer cust : customers) {
                        if (cust != null) {
                            double totalBeforeTax = cust.getPizzaPrice() * cust.getPizzaNumber() + (cust.getDrinks() * 3);
                            double tax = totalBeforeTax * 0.0625;
                            double totalAfterTax = totalBeforeTax + tax;
                            double tipPercentage = cust.getTip(); 
                            double tip = totalBeforeTax * (tipPercentage / 100);
                            double totalOrder = totalAfterTax + tip;
                            System.out.println("Order total: $ " + totalOrder);
                        }
                    }
                    break;

                    //Calculates the discount for each order
                    case 10:
                    for (Customer cust : customers) {
                        if (cust != null) {
                            double discount = 0;
                            double pizzaPrice = cust.getPizzaPrice();
                            double pizzaNum = cust.getPizzaNumber();
                            if (pizzaNum >= 5) {
                                discount = pizzaPrice; // One free pizza for order of 5 for more
                        }
                            System.out.println("Discount for " + cust.getFirstName() + " " + cust.getLastName() 
                            + ": $" + discount);
                        }
                    }
                    break;

                //Calculates the average of all orders and tips
                case 11:
                    double totalOrder = 0;
                    double totalTip = 0;
                    for (Customer cust : customers) {
                        if (cust != null) {
                            double totalBeforeTax = cust.getPizzaPrice() * cust.getPizzaNumber() + (cust.getDrinks() * 3);
                            double tax = totalBeforeTax * 0.0625;
                            double totalAfterTax = totalBeforeTax + tax;
                            double tipPercentage = cust.getTip(); 
                            double tip = totalBeforeTax * (tipPercentage / 100);
                            totalOrder += totalAfterTax + tip;
                            totalTip += tip;
                        }
                    }
                    System.out.println("Average of all orders: $" + (totalOrder / numCustomers));
                    System.out.println("Average of all tips: $" + (totalTip / numCustomers));
                    break;   

                //Displays all managers
                case 12:
                System.out.println("List of Managers:");
                    for (Employee emp : employees) {
                        if (emp != null && emp.getPosition().equalsIgnoreCase("Manager")) {
                            System.out.println(emp.getFirstName() + " " + emp.getLastName());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Enter a valid number.");
            }
        }
    }}

