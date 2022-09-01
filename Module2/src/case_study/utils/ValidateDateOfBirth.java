package case_study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateDateOfBirth {
    private static final Scanner scan = new Scanner(System.in);
    public static MyDate getDateInfo(int minAge, int maxAge) {
        MyDate date;
        while (true)
            try {
                date = new MyDate(scan.nextLine());
                if (date.getAge() < minAge || date.getAge() > maxAge) {
                    throw new Exception("Age must be from " + minAge + " to " + maxAge + " years old");
                }
                return date;
            } catch (ParseException e) {
                System.out.println("Data is incorrect or not in the format dd/MM/yyyy. Please re-enter!");
            } catch (Exception e) {
                System.out.println("Age must be more than 18 and less than 100!, again: ");
            }
    }

    public static class MyDate implements Comparable<MyDate> {
        private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        private String strDate;
        private Date date = new Date();

        public MyDate() {
        }

        public MyDate(String strDate) throws ParseException {
            formatter.setLenient(false);
            this.strDate = strDate;
            this.date = formatter.parse(this.strDate);
        }

        public String getStrDate() {
            return strDate;
        }

        public void setStrDate(String strDate) throws ParseException {
            formatter.setLenient(false);
            this.strDate = strDate;
            this.date = formatter.parse(this.strDate);
        }

        public Date getDate() {
            return date;
        }

        public int getAge() throws ParseException {
            Date now = new Date();
            return (int) ((now.getTime() - this.date.getTime()) / 31556926 / 1000);
        }

        public static int getDays(MyDate startDate, MyDate endDate) {
            return (int) ((endDate.getDate().getTime() - startDate.getDate().getTime()) / 86400000);
        }
        @Override
        public int compareTo(MyDate o) {
            return 0;
        }

        @Override
        public String toString() {
            return "MyDate " +
                    "strDate = " + strDate +
                    ", date = " + date;
        }
    }
}
