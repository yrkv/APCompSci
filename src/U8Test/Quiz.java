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
        setGrade(val);
    }

    private void setGrade(int val)
    {
        grade = (val < 60) ?
                "F" : (val < 70) ?
                "D" : (val < 80) ?
                "C" : (val < 90) ?
                "B" :
                "A";
    }

    public String getResult()
    {
        return grade;
    }
}
