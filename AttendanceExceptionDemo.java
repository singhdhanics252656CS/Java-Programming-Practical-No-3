package p1;

import java.util.Scanner;

// Custom exception class
class LowAttendanceException extends Exception {
    public LowAttendanceException(String message) {
        super(message);
    }
}

// Class to check attendance
class AttendanceDemo {

    public void checkAttendance(int attendance) throws LowAttendanceException {

        if (attendance < 75) {
            throw new LowAttendanceException(
                "Attendance is below 75%. Student is not eligible for exams."
            );
        } 
        else if (attendance > 100) {
            throw new LowAttendanceException(
                "Attendance percentage cannot exceed 100."
            );
        } 
        else {
            System.out.println(
                "Attendance is valid. Student is eligible for exams."
            );
        }
    }
}

// Main class
public class AttendanceExceptionDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AttendanceDemo demo = new AttendanceDemo();

        System.out.print("Enter student attendance percentage: ");
        int attendance = sc.nextInt();

        try {
            demo.checkAttendance(attendance);
        } 
        catch (LowAttendanceException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }

        sc.close();
    }
}