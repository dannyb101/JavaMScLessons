import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //create separate scanners for each data type
    static Scanner intScan = new Scanner(System.in);
    static Scanner stringScan = new Scanner(System.in);
    static Scanner nullScan = new Scanner(System.in);

    public static void runLesson(Lesson lesson){

        //iterate over text arrays in each lesson
        for(int i = 0; i < lesson.getTexts().size(); i++){
            System.out.println(lesson.getTexts().get(i));
            System.out.println("Press enter to advance.");
            nullScan.nextLine();
        }

    }

    public static void runQuiz(Quiz quiz){
        System.out.println("Welcome to the quiz, try to answer all the questions. " +
                "If you do not know a question hazard a guess. You never know might just learn something!" +
                "\n\nPress enter to proceed to the first question ...");
        nullScan.nextLine();

        //Iterate over questions and answers array and print questions to console
        for (int i = 0; i < quiz.getQuestions().size(); i++){
            Question QA = quiz.getQuestions().get(i);
            String question = QA.getQuestion();
            String answer = QA.getAnswer();
            String[] wrongAnswers = QA.getWrongAnswers();
            System.out.println(question);

            //create random integer to randomise appearance of correct answer
            Random rand = new Random();
            int intRandom = rand.nextInt(3);
            boolean correctPrinted = false;
            int x = 0;
            String[] choiceArray = new String[]{"(a)", "(b)", "(c)", "(d)"};
            for(int j = 0; j < wrongAnswers.length; j++){
                System.out.print(choiceArray[x] + "   ");


                //;lets maflansdf haoseihf
                //display correct answer at random
                if(j == intRandom && !correctPrinted){
                    System.out.println(answer);
                    quiz.addCorrectAnswer(choiceArray[x].substring(1,2));
                    correctPrinted = true;
                    j--;
                }
                else{
                    System.out.println(wrongAnswers[j]);
                }
                x++;
            }

            //check user input and add to userAnswers array
            System.out.print("Answer:  ");
            String userAnswer = stringScan.nextLine();
            System.out.println("User inputted " + userAnswer);
            quiz.addUserAnswer(userAnswer);
        }

    }

    public static void checkAnswers(Quiz quiz){
        //iterate over answers and print success/not to console
        double numberCorrectAnswers = 0;
        for(int i = 0; i < quiz.getQuestions().size(); i++){
            System.out.printf("Question %d was answered ", i+1 );
            if(quiz.getCorrectAnswers().get(i).equals(quiz.getUserAnswers().get(i).toLowerCase())){
                System.out.println("correctly. Well done!");
                numberCorrectAnswers +=1;
            }
            else{
                System.out.println("incorrectly. Better luck next time.");
            }
        }

        //Wipe answer arrays in preparation for next question
        quiz.wipeCorrectAnswers();
        quiz.wipeUserAnswers();

        //Display quiz score and check pass
        //also add user to userCompletionArray if passed (50%)
        int quizScore = (int) Math.round(100 * numberCorrectAnswers / quiz.getQuestions().size());
        System.out.printf("You scored %d%%", quizScore);
        if(quizScore >= 50){
            System.out.println(" ... Congratulations you passed the lesson. " +
                    "Please enter your name below to maintain your record.");
            String userName = stringScan.nextLine();
            quiz.addUserCompletion(userName);
        }else{
            System.out.println(" ... Unfortunately you didn't pass the lesson this time. " +
                    "Keep up the hard work and I'm sure you'll pass next time!");
        }
    }

    public static void main(String[] args) {
        Question q1 = new Question("What is the correct answer?",
                "this is",
                new String[]{"not this", "not this", "not this"});

        Question q2 = new Question("Why is the correct answer?",
                "THIS IS",
                new String[]{"not ", "not ", "not "});
        Question q3 = new Question("What is the correct answer?",
                "this is",
                new String[]{"not this", "not this", "not this"});

        Question q4 = new Question("Why is the correct answer?",
                "THIS IS",
                new String[]{"not ", "not ", "not "});

        ArrayList<String> texts = new ArrayList<String>();

        texts.add("This is the first line of the lesson");
        texts.add("This is the second line of the lesson");
        texts.add("This is the third line of the lesson");

        Quiz quiz1 = new Quiz();
        quiz1.addQuestion(q1);
        quiz1.addQuestion(q2);

        Quiz quiz2 = new Quiz();
        quiz2.addQuestion(q3);

        Quiz quiz3 = new Quiz();
        quiz3.addQuestion(q4);

        Lesson l1 = new Lesson("First lesson", texts, quiz1);
        Lesson l2 = new Lesson("Second lesson", texts, quiz2);
        Lesson l3 = new Lesson("Third lesson", texts, quiz3);


        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(l1);
        lessons.add(l2);
        lessons.add(l3);


        System.out.println("Welcome to the MSc Software Engineering learning resource. " +
                "Please press enter to proceed to the main menu.");
        nullScan.nextLine();


        int choice1 = 0;
        int choice2 = 0;
        while (choice1 != 4) {
            System.out.println("**************** Main Menu ****************\n");
            System.out.println("1.   Lessons");
            System.out.println("2.   Instructions");
            System.out.println("3.   User directory");
            System.out.println("4.   Exit\n");
            System.out.print("Enter your selection: ");
            choice1 = intScan.nextInt();
            System.out.println();
            while (choice1 < 1 || choice1 > 4) {
                System.out.print("Incorrect input please try again: ");
                choice1 = intScan.nextInt();
            }
            switch (choice1) {
                case 1:
                    System.out.println("Please select the lesson you would like to complete from the selection below:\n");
                    for (int i = 0; i < lessons.size(); i++) {
                        System.out.println(i + 1 + ".   " + lessons.get(i).getTitle());
                    }
                    System.out.println(lessons.size() + 1 + ".   Return to main menu\n");
                    System.out.print("Enter your selection: ");
                    choice2 = intScan.nextInt();
                    if (choice2 == lessons.size() + 1) {
                        break;
                    }
                    while (choice2 < 1 || choice2 > lessons.size()) {
                        System.out.print("Incorrect input please try again: ");
                        choice2 = intScan.nextInt();
                    }
                    Lesson chosenLesson = lessons.get(choice2 - 1);

                    runLesson(chosenLesson);
                    runQuiz(chosenLesson.getLessonQuiz());
                    checkAnswers(chosenLesson.getLessonQuiz());

                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("This program contains lessons on various subjects taught on the Software Engineering MSc at Cardiff University. " +
                            "\nLessons are displayed in small bite-sized chunks of text and are followed by a short quiz. " +
                            "\nA score of 50% is required to pass each quiz and upon completion your name will be stored for future reference.\n\n");
                    System.out.println("Please press enter to proceed to return to the main menu.");
                    nullScan.nextLine();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("This page displays any lessons where users have completed lessons and those users:\n");
                    int count = 0;
                    for (int i = 0; i < lessons.size(); i++) {
                        System.out.println(lessons.get(i).getTitle() + ":\n");
                        ArrayList<String> userArray = lessons.get(i).getLessonQuiz().getUserCompletionArray();
                        if (userArray.isEmpty()) {
                            System.out.println("No users have completed this lesson yet.");
                        } else {
                            for (int j = 0; j < userArray.size(); j++) {
                                count += 1;
                                System.out.println(userArray.get(j));
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Press enter to return to the main menu.");
                    nullScan.nextLine();
                    break;
            }
        }
        nullScan.close();
        intScan.close();
        stringScan.close();
    }

}
