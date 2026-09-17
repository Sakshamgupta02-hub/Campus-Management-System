import java.io.Serializable;

public class Marks implements Serializable {

    private double subject1;
    private double subject2;
    private double subject3;

    private boolean entered;

    public Marks() {
        subject1 = 0;
        subject2 = 0;
        subject3 = 0;
        entered = false;
    }

    // Set or update marks

    public boolean setMarks(double subject1, double subject2, double subject3) {

        if (subject1 < 0 || subject1 > 100) {
            return false;
        }

        if (subject2 < 0 || subject2 > 100) {
            return false;
        }

        if (subject3 < 0 || subject3 > 100) {
            return false;
        }

        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;

        this.entered = true;

        return true;
    }

    public boolean isEntered() {
        return entered;
    }

    // Calculate average

    public double getAverage() {

        return (subject1 + subject2 + subject3) / 3;
    }

    // Calculate grade

    public String getGrade() {

        if (!entered) {
            return "Not Entered";
        }

        double average = getAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {

        if (!entered) {
            return "Marks: Not Entered";
        }

        return "Subject 1 : " + subject1 +
                "\nSubject 2 : " + subject2 +
                "\nSubject 3 : " + subject3 +
                "\nAverage   : " + String.format("%.2f", getAverage()) +
                "\nGrade     : " + getGrade();
    }
}