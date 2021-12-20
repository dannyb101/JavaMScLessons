import java.util.ArrayList;

//Quiz class to hold Question objects for quiz as well as user answers and store user completion
//All attributes and functions are explicitly named
public class Quiz {

    //Attributes
    private ArrayList<Question> questionsArray;
    private ArrayList<String> userAnswers;
    private ArrayList<String> correctAnswers;
    private ArrayList<String> userCompletionArray;


    //Constructors
    public Quiz() {
        this.questionsArray = new ArrayList<Question>();
        this.userAnswers = new ArrayList<String>();
        this.correctAnswers = new ArrayList<String>();
        this.userCompletionArray = new ArrayList<String>();
    }

    public Quiz(ArrayList<Question> questions) {
        this.questionsArray = questions;
        this.userAnswers = new ArrayList<String>();
        this.correctAnswers = new ArrayList<String>();
        this.userCompletionArray = new ArrayList<String>();
    }


    //Getters
    public ArrayList<Question> getQuestions(){ return this.questionsArray; }

    public ArrayList<String> getUserAnswers(){
        return this.userAnswers;
    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public ArrayList<String> getUserCompletionArray() {return this.userCompletionArray; }


    //~Setters
    public void addUserCompletion(String user){
        this.userCompletionArray.add(user);
    }

    public void addCorrectAnswer(String answer){
        this.correctAnswers.add(answer);
    }

    public void addUserAnswer(String answer){
        this.userAnswers.add(answer);
    }


    //Methods to clear arrays for later re-use
    public void wipeCorrectAnswers(){
        this.correctAnswers.clear();
    }

    public void wipeUserAnswers(){
        this.userAnswers.clear();
    }


}
