//Write a program to create a quiz program.
// Set 20 questions (Computer fundamental, Java basic, SQA Interview questions and General Knowledge) by taking user input and save in JSON file named as question-bank.
// json Then when run program, randomly 5 questions will be appeared to user and user will input the correct option.
// If answer is correct, score will be added. Finally after ending the quiz, show the total score out of 5.


package json_read_write;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class prob_2 {
    static String fileName = "/Users/macbook/Desktop/Test_Automation/Testing Projects/java automation_testing/json/Quesbank.json";
    static int numberOfQuestions = 1;
    static int answerCounter = 0;
    static int min = 0, max = 0;
    static int questionsToBeAnswered = 5;

    public static void WriteJSONQues() throws IOException, ParseException {
        char ch;
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject quesObj = new JSONObject();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter question number " + numberOfQuestions + ":");
            quesObj.put("Question", scanner.nextLine());
            System.out.println("Enter 1st option: ");
            quesObj.put("Option-1", scanner.nextLine());
            System.out.println("Enter 2nd option: ");
            quesObj.put("Option-2", scanner.nextLine());
            System.out.println("Enter 3rd option: ");
            quesObj.put("Option-3", scanner.nextLine());
            System.out.println("Enter 4th option: ");
            quesObj.put("Option-4", scanner.nextLine());
            System.out.println("Answer: ");
            quesObj.put("Answer", scanner.nextLine());

            JSONArray jsonArray = (JSONArray) obj;
            //System.out.print(jsonArray);
            jsonArray.add(quesObj);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            System.out.println(jsonArray);
            System.out.println("\nDo you want to add more questions?[y/n]");
            ch = scanner.next().charAt(0);
            numberOfQuestions++;
        } while (ch != 'n');
    }

    public static void ReadJSONQues() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        max = jsonArray.size();
        for (int i = 1; i <= questionsToBeAnswered; i++) {
            int random = (int) (Math.random() * ((max - min) + min));
            JSONObject json = (JSONObject) jsonArray.get(random);
            String question = (String) json.get("Question");
            String option1 = (String) json.get("Option-1");
            String option2 = (String) json.get("Option-2");
            String option3 = (String) json.get("Option-3");
            String option4 = (String) json.get("Option-4");
            String  answer = (String) json.get("Answer");
            System.out.println("Question: " + question);
            System.out.println("Option - 1: " + option1);
            System.out.println("Option - 2: " + option2);
            System.out.println("Option - 3: " + option3);
            System.out.println("Option - 4: " + option4);
            System.out.println("Input your choice. 1/2/3/4?");
            Scanner scanner = new Scanner(System.in);
            String  choice = scanner.next();
            if (choice.equals(answer)) {
                System.out.println("Your answer is correct!\n");
                answerCounter++;
            } else {
                System.out.println("Your answer is wrong!\n");
            }
        }
    }

    public static void main(String[] args) throws IOException, ParseException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the CTFL demo test!");
        System.out.println("1. Start the test!");
        System.out.println("2. Write questions in to the Question Bank");
        System.out.println("0. Leave");
        int readWriteChoice = scanner.nextInt();

        switch (readWriteChoice){
            case 1:
                ReadJSONQues();
                System.out.println("You have gotten " + answerCounter + " out of " + questionsToBeAnswered + ".");
                break;
            case 2:
                WriteJSONQues();
                break;
            default:
                System.exit(0);
        }
    }
}