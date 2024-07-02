package Task121;
public class DateTask {
   
   // instance variables
private byte day;
 private byte month;
 private short year;
// Constructors:

// The no-args constructor
public DateTask() {
    this (1,1,1);
    
}
// Constructor that takes 3 arguments
public DateTask(int month, int day, int year) {
    setDate(month, day, year);
}
// Methods
public String toString() {
    return String.format ("%02d-%02d-%04d", this.month, this.day, this.year);
}
public void setDate(int m, int d, int y) {
    if (valid(d, m, y)) {
        this.day = (byte) d;
        this.year = (short) y;
        this.month = (byte) m;
    }
    else{
        throw new IllegalArgumentException("Invalid date: " + m + "/" + d + "/" + y);
       // this.day = (byte) 0;
       // this.year = (short) 0;
        //this.month = (byte) 0;
    }
}
public static void leapYears() {
    for (int i = 1980; i <= 2023; i = i + 4) {
        if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0))
            System.out.println("The year " + i + " is a leap year");
    }
}
public byte getDay() {
    return day;
}
public void setDay(int day) {
    if (valid(day, month, year)) {
        this.day = (byte) day;
    }
    else {
        throw new IllegalArgumentException("Invalid day: " + day);
    }
    
}
public int getMonth() {
    return month;
}
public void setMonth(int month) {
    if (valid(day, month, year)) {
        this.month = (byte) month;
    }
    else{
        this.month = (byte) 0;
    }
}
public int getYear() {
    return year;
}
public void setYear(int year) {
    if (valid(day, month, year)) {
        this.year = (short) year;
    }
    else {
        throw new IllegalArgumentException("Invalid year: " + year);
    }
}
private boolean valid(int day, int month, int year) {
    if (day > 31 || day < 1 || month > 12 || month < 1 || year < 1)  {
        return false;
    }
    switch (month) {
        case 4:
        case 6:
        case 9:
        case 11:
            return (day <= 30);
        case 2:
            return day <= 28 || (day == 29 && year % 4 == 0);
    }
    return true;
}
}
