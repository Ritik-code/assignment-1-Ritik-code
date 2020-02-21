public class Person
{
    private String First_Name;
    private String Last_Name;
    private long[] arr = new long[5];
    private String Email_ID;
    int i=0;

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public long[] getArr() {
        return arr;
    }

    public void setArr(long arr) {
        this.arr[i] = arr;
        i++;
    }

    public String getEmail_ID() {
        return Email_ID;
    }

    public void setEmail_ID(String email_ID) {
        Email_ID = email_ID;
    }
}
