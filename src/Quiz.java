import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Quiz {

    private ArrayList<Question> questionsArray;
    private ArrayList<String> userAnswers;
    private ArrayList<String> correctAnswers;
    private ArrayList<String> userCompletionArray;
    Scanner input = new Scanner(System.in);

    public Quiz(ArrayList<Question> questions) {
        this.questionsArray = questions;
        this.userAnswers = new ArrayList<String>();
        this.correctAnswers = new ArrayList<String>();
        this.userCompletionArray = new ArrayList<String>();
    }

    public Quiz() {
        this.questionsArray = new ArrayList<Question>();
        this.userAnswers = new ArrayList<String>();
        this.correctAnswers = new ArrayList<String>();
        this.userCompletionArray = new ArrayList<String>();
    }

    public void addQuestion(Question question) {
        this.questionsArray.add(question);
    }

    public Question getIndexedQuestion(int index){
        return this.questionsArray.get(index);
    }

    public ArrayList<Question> getQuestions(){
        return this.questionsArray;
    }

    public boolean areQuestionsEmpty(){
        return this.questionsArray.isEmpty();
    }

    public ArrayList<String> getUserAnswers(){
        return this.userAnswers;
    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public ArrayList<String> getUserCompletionArray() {return this.userCompletionArray; }

    public void addUserCompletion(String user){
        this.userCompletionArray.add(user);
    }

    public void addCorrectAnswer(String answer){
        this.correctAnswers.add(answer);
    }

    public void wipeCorrectAnswers(){
        this.correctAnswers.clear();
    }

    public void addUserAnswer(String answer){
        this.userAnswers.add(answer);
    }

    public void wipeUserAnswers(){
        this.userAnswers.clear();
    }

//    public void askQuestions(){
//        System.out.println("Welcome to the quiz, try to answer all the questions. " +
//                "If you do not know a question hazard a guess. You never know might just learn something! " +
//                "\n\nPress enter to proceed to the first question ...");
//        input.nextLine();
//        //Iterate over questionArray and print questions to console
//        for (int i = 0; i < this.questionsArray.size(); i++){
//            Question QA = this.questionsArray.get(i);
//            String question = QA.getQuestion();
//            String answer = QA.getAnswer();
//            String[] wrongAnswers = QA.getWrongAnswers();
//            System.out.println(question);
//            Random rand = new Random();
//            int intRandom = rand.nextInt(3);
//            boolean correctPrinted = false;
//            int x = 0;
//            for(int j = 0; j < wrongAnswers.length; j++){
//                System.out.print(choiceArray[x] + "   ");
//
//                //display correct answer at random
//                if(j == intRandom && !correctPrinted){
//                    System.out.println(answer);
//                    correctAnswers.add(choiceArray[x].substring(1,2));
//
//                    correctPrinted = true;
//                    j--;
//                }
//                else{
//                    System.out.println(wrongAnswers[j]);
//                }
//                x++;
//            }
//
//            //check user input and add to userAnswers array
//            System.out.print("Answer:  ");
//            String userAnswer = input.nextLine();
//            System.out.println("User inputted " + userAnswer);
//            userAnswers.add(userAnswer);
//        }
//    }

//    public void checkAnswers(){
//
//        //iterate over answers and print success/not to console
//        double numberCorrectAnswers = 0;
//        for(int i = 0; i < this.questionsArray.size(); i++){
//            System.out.printf("Question %d was answered ", i+1 );
//            if(this.correctAnswers.get(i).equals(userAnswers.get(i).toLowerCase())){
//                System.out.println("correctly. Well done!");
//                numberCorrectAnswers +=1;
//            }
//            else{
//                System.out.println("incorrectly. Better luck next time.");
//            }
//        }
//
//        //Display quiz score and check pass
//        //also add user to userCompletionArray if passed (50%)
//        int quizScore = (int) Math.round(100 * numberCorrectAnswers / this.questionsArray.size());
//        System.out.printf("You scored %d%%", quizScore);
//        if(quizScore >= 50){
//            System.out.println(" ... Congratulations you passed the lesson. " +
//                    "Please enter your name below to maintain your record.");
//            Scanner input = new Scanner(System.in);
//            String userName = input.nextLine();
//            userCompletionArray.add(userName);
//        }else{
//            System.out.println(" ... Unfortunately you didn't pass the lesson this time. " +
//                    "Keep up the hard work and I'm sure you'll pass next time!");
//        }
//    }

}
