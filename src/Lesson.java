import java.util.ArrayList;
import java.util.Scanner;

public class Lesson {


    //Attributes
    private String title;
    private ArrayList<String> texts;
    private Quiz lessonQuiz;
    private Scanner input = new Scanner(System.in);


    //Constructors
    public Lesson() {
        this.title = "";
        this.texts = new ArrayList<String>();
        this.lessonQuiz = new Quiz();
    }

    public Lesson(String title, ArrayList<String> texts, Quiz lessonQuiz) {
        this.title = title;
        this.texts = texts;
        this.lessonQuiz = lessonQuiz;
    }


    //Getters
    public ArrayList<String> getTexts() { return texts; }

    public String getTitle() {
        return title;
    }

    public Quiz getLessonQuiz() {
        return lessonQuiz;
    }


    //Setters (For future developer use)
    public void setTexts(ArrayList<String> texts) {
        this.texts = texts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLessonQuiz(Quiz lessonQuiz){
        this.lessonQuiz = lessonQuiz;
    }

    public void addText(String text){
        this.texts.add(text);
    }


}
