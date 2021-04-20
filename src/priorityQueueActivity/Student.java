package priorityQueueActivity;

/**
 * The Student class keeps track of the following pieces of data
 * about a student: the student's name, ID number, the number of
 * credits the student has earned toward graduation, and whether
 * the student is paid up with respect to university bills.
 * For the purposes of working with a PriorityQueue, we also add the
 * graduationYear and whether declared or intending to declare a CS Major.
 * All of this information is entirely private to the class.
 * Clients can obtain this data only by using the various methods
 * defined by the class.
 */

public class Student implements Comparable<Student> {

    /* Private instance variables */
    private String studentLastName;   /* The student's name           */
    private String studentFirstName;   /* The student's name           */
    private int studentID;        /* The student's ID number      */
    private double creditsEarned; /* The number of credits earned */
    private boolean paidUp;       /* Whether student is paid up   */
    private int graduationYear;   /* year of graduation */
    private boolean csMajor;      /* declared or intending to declare CS major */

    /** The number of credits required for graduation */
    public static final double CREDITS_TO_GRADUATE = 32.0;


    /**
     * Creates a new Student object with the specified name and ID.
     *
     * @param lastName The student's last name as a String
     * @param firstName The student's first name as a String
     * @param id The student's ID number as an int
     */
    public Student(String lastName, String firstName, int id) {
        studentLastName = lastName;
        studentFirstName = firstName;
        studentID = id;
    }

    /**
     * Creates a new Student object with all five parameters initialized.
     *
     * @param lastName The student's last name as a String
     * @param firstName The student's first name as a String
     * @param id        The student's ID number as an int
     * @param graduationYear The student's graduation year as an int
     * @param csMajor        Boolean indicating whether the student is a CS major or intends to be
     */
    public Student(String lastName, String firstName, int id, int graduationYear, boolean csMajor) {
        this(lastName, firstName, id);
        this.graduationYear = graduationYear;
        this.csMajor = csMajor;
    }

    /**
     *
     * @return the last name of this student
     */
    public String getStudentLastName() {
        return studentLastName;
    }

    /**
     *
     * @return the first name of this student
     */
    public String getStudentFirstName() {
        return studentFirstName;
    }

    /**
     * Gets the ID number of this student.
     * @return The ID number of this student
     */
    public int getID() {
        return studentID;
    }

    /**
     * Sets the number of credits earned.
     * @param credits The new number of credits earned
     */
    public void setCredits(double credits) {
        creditsEarned = credits;
    }

    /**
     * Gets the number of credits earned.
     * @return The number of credits this student has earned
     */
    public double getCredits() {
        return creditsEarned;
    }

    /**
     * Sets whether the student is paid up.
     * @param flag The value true or false indicating paid-up status
     */
    public void setPaidUp(boolean flag) {
        paidUp = flag;
    }

    /**
     * Returns whether the student is paid up.
     * @return Whether the student is paid up
     */
    public boolean isPaidUp() {
        return paidUp;
    }

    /**
     *
     * @return  graduation year of student
     */
    public int getGraduationYear() {
        return graduationYear;
    }

    /**
     *
     * @return whether student is declaring or has declared a CS major
     */
    public boolean isCsMajor() {
        return csMajor;
    }

    /**
     * Creates a string identifying this student.
     * @return The string used to display this student
     */
    @Override
    public String toString() {
        return studentFirstName + " " + studentLastName + " (#" + studentID + "), class of: " + graduationYear ;
    }

    /**
     * Checks for equality of two Student objects
     *
     * @param other another Student object
     * @return true if other is a non-null Student object and
     *         the full name (first and last) and the ID of other are equal
     *         to those values in this Student object. Otherwise return false.
     */
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other != null && other instanceof Student) {
            Student that = (Student) other;
            result = ((studentLastName.equals(that.studentLastName)) &&
                    (studentFirstName.equals(that.studentFirstName)) &&
                    (studentID == that.studentID));
        }
        return result;
    }

    /**
     * Compares one Student to another by last name, then first neme.
     *
     * @param other the Student object to compare to this one: must be a non-null Student
     *
     * @return negative value if this Student object is naturally less than other by String comparison
     *         of last name then first name, return 0 if they are equal, return a positive number
     *         if this Student is naturally greater than other.
     */
    @Override
    public int compareTo(Student other) {
        if (other != null && other instanceof Student) {
            Student that = (Student) other;
            // compare last names
            int lastNameCompare = studentLastName.compareTo(that.studentLastName);
            if (lastNameCompare == 0) { // equal last names
                return studentFirstName.compareTo(that.studentFirstName);
            } else {
                return lastNameCompare;
            }
        }
        return 0;
    }
}

