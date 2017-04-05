// Yegor Kuznetsov
//
// This class is used to simulate a quiz score.

public class Quiz implements Measurable
{
    private int score;
    private String grade;

    public Quiz(int val)
    {
        score = val;
        setGrade();
    }

    private void setGrade()
    {
        grade = (score < 60) ?
                "F" : (score < 70) ?
                "D" : (score < 80) ?
                "C" : (score < 90) ?
                "B" :
                "A";
    }

    public String getResult()
    {
        return grade;
    }
}
