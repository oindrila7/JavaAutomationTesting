//Write a program to withdraw money from ATM booth. Save PIN and balance in a json file.
// Scenario: User goes to an ATM boot. Insert card (assume card has inserted) and input correct PIN.
// If PIN is wrong, system will ask to give correct PIN max 3 times. If user inputs wrong PIN 3 times, print that: "Card is blocked".
// If PIN is correct, then system will give 2 options to user as 1. Check Balance
// 2. Withdraw Money. User will choose any option. If user inputs amount that is not divisible by 500, then error message will be shown as "Please input amount that is multiply by 500".
// If user inputs more than balance, print error message as "Not enough balance" After withdrawing money successfully, balance will be deducted and update json file.
// Then User will choose option 1 again to check the current balance.


package json_read_write;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class prob_1 {
    static Scanner scanner;

    public static long GettingBalance() throws IOException, ParseException {
        String fileName = "/Users/macbook/Desktop/Test_Automation/Testing Projects/java automation_testing/json/AccountInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(fileName));
        JSONObject balanceObject = (JSONObject) object;
        long balance = (long) balanceObject.get("balance");
        return balance;
    }

    public static void CheckBalance() throws IOException, ParseException {
        long balance = GettingBalance();
        System.out.println("Your balance is: " + balance + ".");

        System.out.println("\n1. Withdraw money");
        System.out.println("2. Deposit money");
        System.out.println("0. Leave");
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                if (GettingBalance() < 500) {
                    System.out.println("Your balance is less than 500.");
                    System.out.println("Do you wish to deposit money?");
                    System.out.println("1. Yes");
                    System.out.println("0. Leave");
                    int input = scanner.nextInt();
                    if (input == 1) {
                        DepositMoney();
                    } else {
                        System.exit(0);
                    }
                } else {
                    WithdrawMoney();
                }
                break;
            case 2:
                DepositMoney();
                break;
            default:
                System.exit(0);
        }
        //System.exit(0);
    }

    public static void WithdrawMoney() throws IOException, ParseException {
        long amount = GettingBalance();
        System.out.println("Enter the amount to withdraw which have in your current balance:");
        System.out.println("Entered amount must be multiplied by 500!");
        int withdrawingAmount = scanner.nextInt();
        if (withdrawingAmount % 500 == 0) {
            if (withdrawingAmount <= amount) {
                amount = amount - withdrawingAmount;
                System.out.println("Withdraw successful!!");
                WriteJSON(amount);
                System.out.println("\n1. Check balance");
                System.out.println("2. Withdraw money");
                System.out.println("3. Deposit money");
                System.out.println("0. Leave");
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        CheckBalance();
                        break;
                    case 2:
                        if (GettingBalance() < 500) {
                            System.out.println("Your balance is less than 500.");
                            System.out.println("Do you wish to deposit money?");
                            System.out.println("1. Yes");
                            System.out.println("0. Leave");
                            int input = scanner.nextInt();
                            if (input == 1) {
                                DepositMoney();
                            } else {
                                System.exit(0);
                            }
                        } else {
                            WithdrawMoney();
                        }
                        break;
                    case 3:
                        DepositMoney();
                        break;
                    default:
                        System.exit(0);
                }
                //System.exit(0);
            } else {
                System.out.println("Your account does not have that much balance.\n");
                WithdrawMoney();
            }
        } else {
            System.out.println("Withdrawing amount is not multiplied by 500.\n");
            WithdrawMoney();
        }
    }

    public static void DepositMoney() throws IOException, ParseException {
        long amount = GettingBalance();
        System.out.println("Enter the amount of money you wish to deposit: ");
        System.out.println("Depositing amount must be multiplied by 500!");
        int depositingAmount = scanner.nextInt();
        if (depositingAmount % 500 == 0) {
            amount = amount + depositingAmount;
            System.out.println("Your money has been successfully deposited!");
            WriteJSON(amount);
            System.out.println("\n1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("0. Leave");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    CheckBalance();
                    break;
                case 2:
                    if (GettingBalance() < 500) {
                        System.out.println("Your balance is less than 500.");
                        System.out.println("Do you wish to deposit money?");
                        System.out.println("1. Yes");
                        System.out.println("0. Leave");
                        int input = scanner.nextInt();
                        if (input == 1) {
                            DepositMoney();
                        } else {
                            System.exit(0);
                        }
                    } else {
                        WithdrawMoney();
                    }
                    break;
                case 3:
                    DepositMoney();
                    break;
                default:
                    System.exit(0);
            }
        } else {
            System.out.println("Depositing amount is not multiplied by 500.\n");
            DepositMoney();
        }

        System.exit(0);
    }

    public static void PinChecking() throws IOException, ParseException {
        String myPin = ReadJSON();
        int pinCounter = 1;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter your PIN: ");
            String pin = scanner.next();
            if (pinCounter < 3) {
                if (pin.equals(myPin)) {
                    System.out.println("Your pin is correct!\n");
                    break;
                } else {
                    System.out.println("Wrong PIN entered!");
                    pinCounter++;
                }
            } else {
                if (pin.equals(myPin)) {
                    System.out.println("Your pin is correct!\n");
                    break;
                } else {
                    System.out.println("\nYou have entered wrong PIN more than 3 times. \nYour card is blocked!!!");
                    System.exit(0);
                }
            }
        }
    }

    public static void WriteJSON(long amount) throws IOException, ParseException {
        JSONObject accountObject = new JSONObject();
        accountObject.put("pin", "tycoon");
        accountObject.put("balance", amount);
        FileWriter writer = new FileWriter("/Users/macbook/Desktop/Test_Automation/Testing Projects/java automation_testing/json/AccountInfo.json");
        writer.write(accountObject.toJSONString());
        writer.flush();
        writer.close();
    }

    public static String ReadJSON() throws IOException, ParseException {
        String fileName = "/Users/macbook/Desktop/Test_Automation/Testing Projects/java automation_testing/json/AccountInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(fileName));
        JSONObject pinObject = (JSONObject) object;
        String pin = (String) pinObject.get("pin");
        return pin;
    }

    public static void main(String[] args) throws IOException, ParseException {
        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simplicity ATM Booth!");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("0. Leave");
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                PinChecking();
                CheckBalance();
                break;
            case 2:
                PinChecking();
                if (GettingBalance() < 500) {
                    System.out.println("\nYour balance is less than 500.");
                    System.out.println("Do you wish to deposit money?");
                    System.out.println("1. Yes");
                    System.out.println("0. Leave");
                    int input = scanner.nextInt();
                    if (input == 1) {
                        DepositMoney();
                    } else {
                        System.exit(0);
                    }
                } else {
                    WithdrawMoney();
                }
                break;
            case 3:
                PinChecking();
                DepositMoney();
                break;
            default:
                System.exit(0);
        }
    }
}