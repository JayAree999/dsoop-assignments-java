//Collaborator: Suppachoke Areechitsakul, Sumet Saelow, Nutchapol Isariyapruit
// * Name Suppachoke Areechitsakul
// * Student ID 6281553
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Put your name and student id
 */
public class Course {

    // Do not modify these
    private String name;
    private double assignmentWeightPercentage;
    private double quizWeightPercentage;
    private double midtermWeightPercentage;
    private double finalWeightPercentage;
    private List<GradeBook> gradeBooks;


    // Creates a course with default grading scheme:
    //   - assignment 50%
    //   - quiz 10%
    //   - midterm 20%
    //   - final 20%


    public Course(String name) {
        this.name = name;
        gradeBooks= new ArrayList<>() ;
        assignmentWeightPercentage=0.5;
        quizWeightPercentage=0.1;
        midtermWeightPercentage=0.2;
        finalWeightPercentage=0.2;




        // IMPLEMENT THIS
    }

    // Creates a course with a given grading scheme
    public Course(String name, double a, double q, double m, double f) {
        this.name=name;
         assignmentWeightPercentage=a;
         quizWeightPercentage=q;
         midtermWeightPercentage=m;
         finalWeightPercentage=f;
    }


    // Add a grade book to the course
    // You must also update the course reference in the grade book object.
    public void addGradebook(GradeBook gradebook) {


        gradeBooks.add(gradebook);
        gradebook.setCourse(this);

        // IMPLEMENT THIS
    }

    // Returns a List of all grade book objects
    public List<GradeBook> getAllGradeBooks() {
        // IMPLEMENT THIS
        return gradeBooks;
    }

    // Return the average term score across all students
    // You should make a call to getTermAverage() in each student's gradebook.
    // If no students, return -1
    public double getClassAverage(int numAssignmentDrop, int numQuizDrop) {
        if (getAllGradeBooks().size()==0){
            return -1;
        }



        double total =0;
        for (int i =0; i<=getAllGradeBooks().size()-1;i++){
            total+=getAllGradeBooks().get(i).getTermAverage(numAssignmentDrop,numQuizDrop);

        }



        return total/getAllGradeBooks().size();


    }

    // Return the average term score across all students (no assignment/quiz dropping)
    // You should make a call to getTermAverage() in each student's gradebook.
    // If no students, return -1
    public double getClassAverage() {
        return getClassAverage(0,0);
    }



    // Add missing methods here.


    public double getAssignmentWeightPercentage() {
        return assignmentWeightPercentage;
    }

    public double getFinalWeightPercentage() {
        return finalWeightPercentage;
    }

    public double getMidtermWeightPercentage() {
        return midtermWeightPercentage;
    }

    public double getQuizWeightPercentage() {
        return quizWeightPercentage;
    }

    public List<GradeBook> getGradeBooks() {
        return gradeBooks;
    }

    public void setAssignmentWeightPercentage(double assignmentWeightPercentage) {
        this.assignmentWeightPercentage = assignmentWeightPercentage;
    }

    public String getName() {
        return name;
    }

    public void setFinalWeightPercentage(double finalWeightPercentage) {
        this.finalWeightPercentage = finalWeightPercentage;
    }
    public void setGradeBooks(List<GradeBook> gradeBooks) {
        this.gradeBooks = gradeBooks;
    }

    public void setMidtermWeightPercentage(double midtermWeightPercentage) {
        this.midtermWeightPercentage = midtermWeightPercentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuizWeightPercentage(double quizWeightPercentage) {
        this.quizWeightPercentage = quizWeightPercentage;
    }

    // Do not modify this
    public static void main(String[] args) {
        // Create a course with the default grading scheme
        Course course = new Course("Java");

        // Add two grade books
        GradeBook book1 = new GradeBook();
        GradeBook book2 = new GradeBook();
        course.addGradebook(book1);
        course.addGradebook(book2);


        // first student
        book1.setAssignmentScore(1, 100);
        book1.setAssignmentScore(2, 100);
        book1.setAssignmentScore(3, 0);

        book1.setQuizScore(1,100);
        book1.setQuizScore(2,80);

        book1.setMidtermScore(100);
        book1.setFinalScore(100);

        // second student
        book2.setAssignmentScore(1, 90);
        book2.setAssignmentScore(2, 0);
        book2.setAssignmentScore(3, 90);

        book2.setQuizScore(1,80);
        book2.setQuizScore(2,100);

        book2.setMidtermScore(100);
        book2.setFinalScore(100);

        System.out.println("Class average:" + course.getClassAverage());
        System.out.println("Class average:" + course.getClassAverage(1, 1));
    }
}
