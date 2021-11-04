import java.util.*;

public class Main {

    //create separate scanners for each data type to be used across entire program
    static Scanner intScan = new Scanner(System.in);
    static Scanner stringScan = new Scanner(System.in);
    static Scanner nullScan = new Scanner(System.in);

    //function to ensure valid user integer input
    public static int validateUserInt(){
        int userAnswer = -1;
        do{
            try {
                userAnswer = intScan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer: ");
                intScan.next();
            }
        }while(userAnswer < 0);
        return userAnswer;
    }

    //functions to run quiz's and lessons are defined below
    //they have been defined outside of classes in order to decrease coupling
    //and allow for future maintainability.

    //function to runLesson objects and display to user
    public static boolean runLesson(Lesson lesson){

        System.out.println("\n*******************************************\n");

        System.out.println("Welcome to the lesson: " + lesson.getTitle()+
                ". Please follow the instructions to complete the lesson." +
                " There is an option to test your knowledge at the end of the lesson with a short quiz.\n");

        //iterate over text arrays in each lesson and print to console
        for(int i = 0; i < lesson.getTexts().size(); i++){
            System.out.println(lesson.getTexts().get(i));
            System.out.println("Press enter to advance.");
            nullScan.nextLine();
        }
        System.out.print("You have reached the end of the " + lesson.getTitle() + " lesson. " +
                "\nWould you like to complete the quiz now? (y/n): ");

        //Take user input and check input is valid
        String choice = stringScan.nextLine().toLowerCase();
        while(!choice.equals("y") && !choice.equals("n")){
            System.out.print("Incorrect answer inputted, please try again: ");
            choice = stringScan.nextLine().toLowerCase();
        }

        //return true if user wants to run quiz now
        return choice.equals("y");
    }

    public static void runQuiz(Quiz quiz){
        System.out.println("\n*******************************************\n");
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
            System.out.println("Q" + (i+1) + ".   " + question);

            //create random integer to randomise appearance of correct answer
            Random rand = new Random();
            int intRandom = rand.nextInt(3);

            boolean correctPrinted = false;
            int x = 0; //iterator for choiceArray (separate from for loop due to random number)
            String[] choiceArray = new String[]{"(a)", "(b)", "(c)", "(d)"};
            for(int j = 0; j < wrongAnswers.length; j++){
                System.out.print(choiceArray[x] + "   ");

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
            String userAnswer = stringScan.nextLine().toLowerCase();
            while(!userAnswer.equals("a") && !userAnswer.equals("b") && !userAnswer.equals("c") && !userAnswer.equals("d")){
                System.out.print("Incorrect answer inputted, please try again: ");
                userAnswer = stringScan.nextLine().toLowerCase();
            }
            System.out.println("User inputted " + userAnswer);
            quiz.addUserAnswer(userAnswer);
        }

    }

    //Function to validate user input answers against correct answers held in question object
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

        //Create Test Lesson content
        ArrayList<String> texts = new ArrayList<String>();
        texts.add("This is the first line of the lesson");
        texts.add("This is the second line of the lesson");
        texts.add("This is the third line of the lesson");

        //Create test question/answer objects for Test Lesson
        Question q1 = new Question("What is the correct answer?",
                "this is",
                new String[]{"not this", "not this", "not this"});
        Question q2 = new Question("What is the correct answer?",
                "THIS IS",
                new String[]{"not ", "not ", "not "});
        Question q3 = new Question("What is the correct answer?",
                "this is",
                new String[]{"not this", "not this", "not this"});
        Question q4 = new Question("What is the correct answer?",
                "THIS IS",
                new String[]{"not ", "not ", "not "});
        Question q5 = new Question("What is the correct answer?",
                "this is",
                new String[]{"not this", "not this", "not this"});

        //Add questions into quiz and quiz into lesson object
        ArrayList<Question> testQuestions = new ArrayList<Question>(Arrays.asList(q1, q2, q3, q4, q5));
        Quiz quiz1 = new Quiz(testQuestions);
        Lesson testLesson = new Lesson("Test Lesson", texts, quiz1);


        //Create content for server lesson
        ArrayList<String> serverLessonContent = new ArrayList<String>();
        serverLessonContent.add("Client's are programs that request a service such as a browser or git for example");
        serverLessonContent.add("The most common example of this is using a browser to view/request web pages");
        serverLessonContent.add("A server is a program that manages the access to a service such as a web server, a file server or a git server.");
        serverLessonContent.add("To transfer an html document from one machine to another, there is a process.");
        serverLessonContent.add("We use a protocol (set of defined rules) called HTTP. This sends messages between client and server –requests and responses.");
        serverLessonContent.add("In HTTP there are many types of message, GET, POST, HTTP OK(data delivery) ....");
        serverLessonContent.add("To request a page, the client sends a message (GET) and the server replies with a message (OK + the page) or maybe not if it can’t find it.");
        serverLessonContent.add("More precisely, the GET message sends the precise URL of the resource required and the server responds with some meta data about the resource and the contents of the resource");

        //Server questions
        Question q6 = new Question("Which of these is an example of a client?",
                "A browser",
                new String[]{"A keyboard", "Orange", "Microsoft word"});
        Question q7 = new Question("A server is ...",
                "A program that manages the access to a service",
                new String[]{"A waiter in a restaurant", "Orange", "A type of shot in tennis"});
        Question q8 = new Question("Which of these is an example of an HTTP message",
                "GET",
                new String[]{"GO", "HELP", "Orange"});
        Question q9 = new Question("A protocol is ...",
                "A set of defined rules",
                new String[]{"Orange", "A computer game", "A messaging application"});
        Question q10 = new Question("What does a GET message do?",
                "Sends the precise URL of the required resource",
                new String[]{"Plays fetch with the dog", "Informs the user about length of runtime", "Orange"});

        //Add questions and content to Server Lesson object
        ArrayList<Question> serverQuestions = new ArrayList<Question>(Arrays.asList(q6, q7, q8, q9, q10));
        Quiz serverQuiz = new Quiz(serverQuestions);
        Lesson serverLesson = new Lesson("Client Server", serverLessonContent, serverQuiz);


        //Create content for Programming Principles lesson
        ArrayList<String> progPrinciplesContent = new ArrayList<String>();
        progPrinciplesContent.add("Composition and inheritance are ways to re-use classes.");
        progPrinciplesContent.add("Composition is implemented by including existing classes withing new classes. Composition can be used when there is a \"has-a\" relationship between the two classes.");
        progPrinciplesContent.add("Inheritance is implemented by inheriting all of the attributes & methods from an existing class. Inheritance can be used when the child class (the one that is inheriting) is a type of the parent class (the one that is being inherited from).");
        progPrinciplesContent.add("Child & parent classes are also known as subclasses & superclasses or derived class & base class.");
        progPrinciplesContent.add("Even in situations where you as a programmer are not using inheritance all classes will have a parent/superclass.");
        progPrinciplesContent.add("This is because classes which are not subclasses have the built in Object class as their superclass.");

        //Programming principles question/answers
        Question q11 = new Question("In which of these situations would you use composition?",
                "A TV object has a remote control",
                new String[]{"A dog is a type of animal", "A laptop is a type of computer", "Orange"});
        Question q12 = new Question("If a class has no subclasses what is the name of it's super class?",
                "Object",
                new String[]{"None, it doesn't have one", "Orange", "Java"});
        Question q13 = new Question("Which of these is another name for a superclass?",
                "A parent class",
                new String[]{"Orange", "Derived class", "Superman"});
        Question q14 = new Question("Composition and inheritance are a way to ...",
                "Re-use classes in programming",
                new String[]{"Understand human genetics", "Make music", "Orange"});
        Question q15 = new Question("Where should you use inheritance?",
                "Where there is a \"has-a\" relationship between classes.",
                new String[]{"Where there is an \"is-a\" relationship between classes.", "Orange", "When trying to find your estranged father who left to get milk 20 years ago and should be back any minute."});

        //Add prg questions to quiz and quiz to lesson
        ArrayList<Question> progPrinciplesQuestions = new ArrayList<Question>(Arrays.asList(q11, q12, q13, q14, q15));
        Quiz progPrinciplesQuiz = new Quiz(progPrinciplesQuestions);
        Lesson progPrinciplesLesson = new Lesson("Inheritance & Composition", progPrinciplesContent, progPrinciplesQuiz);




        //Create array of lesson objects to display in lesson menu
        ArrayList<Lesson> lessons = new ArrayList<Lesson>(Arrays.asList(testLesson, serverLesson, progPrinciplesLesson));


        System.out.println("Welcome to the MSc Software Engineering learning resource. " +
                "Please press enter to proceed to the main menu.");
        nullScan.nextLine();

        //create choice integers for menus
        int choice1 = 0;
        int choice2 = 0;

        //loop to display menus and loop back to main menu
        while (choice1 != 4) {
            System.out.println("**************** Main Menu ****************\n");
            System.out.println("1.   Lessons");
            System.out.println("2.   Instructions");
            System.out.println("3.   User directory");
            System.out.println("4.   Exit\n");
            System.out.print("Enter your selection: ");

            //check user input is an integer
            choice1 = validateUserInt();
            System.out.println();

            //user input checked for correct input for menu
            while (choice1 < 1 || choice1 > 4) {
                System.out.print("Incorrect input please try again: ");
                choice1 = validateUserInt();
            }

            switch (choice1) {

                //Lessons menu
                case 1:
                    System.out.println("**************** Lessons ******************\n");
                    System.out.println("Please select the lesson you would like to complete from the selection below:\n");

                    //Display available lessons to user in menu format
                    for (int i = 0; i < lessons.size(); i++) {
                        System.out.println(i + 1 + ".   " + lessons.get(i).getTitle());
                    }
                    System.out.println(lessons.size() + 1 + ".   Return to main menu\n");
                    System.out.print("Enter your selection: ");

                    //check user menu input
                    choice2 = validateUserInt();

                    while (choice2 < 1 || choice2 > lessons.size() + 1) {
                        System.out.print("Incorrect input please try again: ");
                        choice2 = validateUserInt();
                    }
                    if (choice2 == lessons.size() + 1) {
                        break;
                    }
                    Lesson chosenLesson = lessons.get(choice2 - 1);

                    //run lesson - returning true if user wants to run quiz
                    boolean quizChoice = runLesson(chosenLesson);
                    if(quizChoice){
                        runQuiz(chosenLesson.getLessonQuiz());
                        checkAnswers(chosenLesson.getLessonQuiz());
                    }

                    System.out.println("\n");
                    break;

                //Instructions menu
                case 2:
                    System.out.println("************** Instructions ***************\n");
                    System.out.println("This program contains lessons on various subjects taught on the Software Engineering MSc at Cardiff University. " +
                            "\nLessons are displayed in small bite-sized chunks of text and are followed by a short quiz. " +
                            "\nA score of 50% is required to pass each quiz and upon completion your name will be stored for future reference.\n\n");
                    System.out.println("Please press enter to proceed to return to the main menu.\n");
                    nullScan.nextLine();
                    System.out.println();
                    break;

                //User completion record for lessons
                case 3:
                    System.out.println("********** User Completion Record **********\n");
                    System.out.println("This page displays the record of users who have passed the quiz for each lesson.\n");
                    int count = 0;

                    //iterate over lessons and check if any users have completed
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
        //close all scanner objects
        nullScan.close();
        intScan.close();
        stringScan.close();
    }

}
