import java.text.SimpleDateFormat;
import java.util.Date;
public class DatesinJava {
    public static void main(String[] args){
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YYYY"); /* This formats the date to the specified format and converts that to a string data type*/
        System.out.println(dateForm.format(thisDate));
    }
}
