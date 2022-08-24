//Collaborator: Suppachoke Areechitsakul, Sumet Saelow, Nutchapol Isariyapruit
// * Name Suppachoke Areechitsakul
// * Student ID 6281553
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Put your name and student id here
 */
public class GradeBook {

    // Do not modify these
    private List<Double> assignmentScores;
    private List<Double> quizScores;
    private double midtermScore;
    private double finalScore;
    private Course course;

    // Creates an empty grade book



    public GradeBook() {






        assignmentScores = new ArrayList<>();
        quizScores = new ArrayList<>();




        // IMPLEMENT THIS
    }

    // Records the score of a particular assignment
    // Note: First assignment is assignment 1
    public void setAssignmentScore(int assignmentNumber, double score) {
        // IMPLEMENT THIS
        for (int n = 0; n <= assignmentNumber; n++) {

            if (assignmentScores.size() < assignmentNumber) {

                assignmentScores.add(0.0);


                continue;


            }

            assignmentScores.set(assignmentNumber - 1, score);


        }

    }


    // Records the score of a particular quiz
    // Note: First quiz is quiz 1
    public void setQuizScore(int quizNumber, double score) {
        for (int n = 0; n <= quizNumber; n++) {

            if (quizScores.size() < quizNumber) {

                quizScores.add(0.0);


                continue;


            }

            quizScores.set(quizNumber - 1, score);


        }

    }


    // Returns average score after dropping <numDrop> lowest scores.
    //
    // You must assume that the total number of assignments/quizzes is the
    // maximum of the assignment ids that has been recorded, and
    // assume scores of 0.0 for unrecorded scores.
    //
    // For example, if only scores of quiz 1 and 3 are recorded,
    // you should assume that there are 3 quizzes and quiz 2 score is 0.0.

    private double getAverageScore(List<Double> scores, int numDrop) {

        Collections.sort(scores);
        double total = 0;

            if (numDrop > scores.size() || numDrop==scores.size()) {
                return 0.0;
            }
            else {

                for (int j = numDrop; j <= (scores.size()-1); j++) {
                    total += scores.get(j);

                }
            }
            total /= scores.size() - numDrop;




        return total;
    }





    public double getAverageQuizScore(int numDrop) {

        return getAverageScore(quizScores,numDrop);

    }




    public double getAverageAssignmentScore(int numDrop) {
        return  getAverageScore(assignmentScores,numDrop);

    }

    // Returns the term weighted average according to the following formula:
    //  term_avg = (avg_assn_score * assn_weight% + avg_quiz_score * quiz_weight%
    //             + midterm_score * midterm_weight% + final_score * final_weight%) / 100
    // If the grading scheme is not define, return -1

    public double getTermAverage(int numAssignmentDrop, int numQuizDrop) {

        if (course == null){
            return -1;
        }
        double assignment = getAverageAssignmentScore(numAssignmentDrop) *course.getAssignmentWeightPercentage();
        double quiz = getAverageQuizScore(numQuizDrop)* course.getQuizWeightPercentage();
        double midterm= midtermScore * course.getMidtermWeightPercentage() ;
        double finalexam = finalScore * course.getFinalWeightPercentage() ;



//        System.out.println(course.getAssignmentWeightPercentage());
//        System.out.println(getAverageQuizScore(numQuizDrop));
//        System.out.println(course.getQuizWeightPercentage());


        return ((assignment+quiz+midterm+finalexam)/100)*100;
    }

    public void printRawScores() {
        System.out.println(assignmentScores);
        System.out.println(quizScores);


    }

    // Add any missing methods here



    public Course getCourse() {
        return course;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public double getMidtermScore() {
        return midtermScore;
    }

    public List<Double> getAssignmentScores() {
        return assignmentScores;
    }
    public List<Double> getQuizScores() {
        return quizScores;
    }

    public void setAssignmentScores(List<Double> assignmentScores) {
        this.assignmentScores = assignmentScores;
    }

    public void setCourse(Course newcourse) {
        course=newcourse;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public void setMidtermScore(double midtermScore) {
        this.midtermScore = midtermScore;
    }

    public void setQuizScores(List<Double> quizScores) {
        this.quizScores = quizScores;
    }




    // Do not modify this
    public static void main(String[] args) {
        GradeBook book = new GradeBook();


        book.setAssignmentScore(1, 80);
        book.setAssignmentScore(3, 88);

        book.setAssignmentScore(2, 90);
//
        book.setQuizScore(1,100);
        book.setQuizScore(2,80);

        book.setMidtermScore(100);
        book.setFinalScore(100);

        book.printRawScores();

        System.out.println("Avg Assignment Score (No drop): " + book.getAverageAssignmentScore(0));
        System.out.println("Avg Assignment Score (drop 1): " + book.getAverageAssignmentScore(1));
        System.out.println("Avg Assignment Score (drop 2): " + book.getAverageAssignmentScore(2));
        System.out.println("Avg Assignment Score (drop 3): " + book.getAverageAssignmentScore(3));
        System.out.println("Avg Assignment Score (drop 4): " + book.getAverageAssignmentScore(4));

        System.out.println("Avg Quiz Score (No drop): " + book.getAverageQuizScore(0));
        System.out.println("Avg Quiz Score (drop 1): " + book.getAverageQuizScore(1));
        System.out.println("Avg Quiz Score (drop 2): " + book.getAverageQuizScore(2));

        book.setAssignmentScore(9, 80);
        book.printRawScores();
        System.out.println("Avg Assignment Score (No drop): " + book.getAverageAssignmentScore(0));

//
//    }
//
//
//}
    }


}
