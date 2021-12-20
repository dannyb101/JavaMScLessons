public class Question {

    //Attributes
    private String question;
    private String answer;
    private String[] wrongAnswers;


    //Constructors
    public Question(){
        this.question = "";
        this.answer = "";
        this.wrongAnswers = new String[3];
    }

    public Question(String question, String answer, String[] wrongAnswers){
        this.question = question;
        this.answer = answer;
        this.wrongAnswers = wrongAnswers;
    }

    //Getters
    public String getQuestion() { return question; }

    public String getAnswer() {
        return answer;
    }

    public String[] getWrongAnswers() {
        return wrongAnswers;
    }


    //Setters (for future developer use)
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setWrongAnswers(String[] wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}
