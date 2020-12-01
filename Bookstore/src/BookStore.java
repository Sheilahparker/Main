import java.io.IOException;
import java.util.*;

public class BookStore {
    private String name;
    private String address;
    private int squareFeet;
    private boolean hasUsedBooks;
    private boolean isOpenToday;
    private String dailyOpeningTime;
    private String dailyClosingTime;
    private ArrayList<String> titles;

    public BookStore() {
        this.name = "";
        this.address = "";
        this.squareFeet = 0;
        this.hasUsedBooks = false;
        this.isOpenToday = false;
        this.dailyOpeningTime = "8:00 am";
        this.dailyClosingTime = "5:00 pm";
        titles = new ArrayList<String>();
       
    }

    public BookStore(String name, String address, int squareFeet, boolean hasUsedBooks, boolean isOpenToday) {
        this.name = name;
        this.address = address;
        this.squareFeet = squareFeet;
        this.hasUsedBooks = hasUsedBooks;
        this.isOpenToday = isOpenToday;
        titles = new ArrayList<String>();
  
    }

    public BookStore(String name, String address, int squareFeet, boolean hasUsedBooks, boolean isOpenToday, String dailyOpeningTime, String dailyClosingTime) {
        this.name = name;
        this.address = address;
        this.squareFeet = squareFeet;
        this.hasUsedBooks = hasUsedBooks;
        this.isOpenToday = isOpenToday;
        this.dailyOpeningTime = dailyOpeningTime;
        this.dailyClosingTime = dailyClosingTime;
       
        titles = new ArrayList<String>();
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public boolean isHasUsedBooks() {
        return hasUsedBooks;
    }

    public void setHasUsedBooks(boolean hasUsedBooks) {
        this.hasUsedBooks = hasUsedBooks;
    }

    public boolean isOpenToday() {
        return isOpenToday;
    }

    public void setOpenToday(boolean openToday) {
        isOpenToday = openToday;
    }

    public String getDailyOpeningTime() {
        return dailyOpeningTime;
    }

    public void setDailyOpeningTime(String dailyOpeningTime) {
        this.dailyOpeningTime = dailyOpeningTime;
    }

    public String getDailyClosingTime() {
        return dailyClosingTime;
    }

    public void setDailyClosingTime(String dailyClosingTime) {
        this.dailyClosingTime = dailyClosingTime;
    }



    public ArrayList<String> getTitles() {
        return titles;
    }

    @Override
    public String toString() {
        return "Bookstore{" + "name='" + name + "'" + ", address='" + address + "'" + "}";
    }
}