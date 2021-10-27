public class Question {

    private String question;
    private String answer;
    private String[] wrongAnswers;

    public Question(String question, String answer, String[] wrongAnswers){
        this.question = question;
        this.answer = answer;
        this.wrongAnswers = wrongAnswers;
    }

    public Question(){
        this.question = "";
        this.answer = "";
        this.wrongAnswers = new String[3];
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(String[] wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}
