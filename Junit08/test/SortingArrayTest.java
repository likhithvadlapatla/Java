import com.ge.app.SortingArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class SortingArrayTest {

    @Test
    void testSortingArray_Performance(){
        SortingArray array=new SortingArray();
        int unsorted[] = {2,5,1};
        /*assertTimeout is a JUnit 5 feature used to ensure that a certain piece of code completes within a specified time limit. This is particularly useful when testing code that is expected to execute within a reasonable amount of time and helps identify performance issues or unexpected delays.*/
        assertTimeout(Duration.ofMillis(5),()->array.sortingArray(unsorted));
    }
}
