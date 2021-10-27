import java.util.ArrayList;
import java.util.Scanner;

public class Lesson {

    private String title;
    private ArrayList<String> texts;
    private Quiz lessonQuiz;
    private Scanner input = new Scanner(System.in);

    public Lesson(String title, ArrayList<String> texts, Quiz lessonQuiz) {
        this.title = title;
        this.texts = texts;
        this.lessonQuiz = lessonQuiz;
    }

    public Lesson() {
        this.title = "";
        this.texts = new ArrayList<String>();
        this.lessonQuiz = new Quiz();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTexts(ArrayList<String> texts) {
        this.texts = texts;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

    public void addText(String text){
        this.texts.add(text);
    }

    public void setLessonQuiz(Quiz lessonQuiz){
        this.lessonQuiz = lessonQuiz;
    }

    public Quiz getLessonQuiz() {
        return lessonQuiz;
    }


}
