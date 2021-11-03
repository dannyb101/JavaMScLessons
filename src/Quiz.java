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


}
