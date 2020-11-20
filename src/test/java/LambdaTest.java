import java.util.Arrays;

public class LambdaTest {
    public static void main(String[] args) {
        Integer[] array = {6,1,2,3,4};

        Arrays.sort(array, (Integer a, Integer b) -> {
            return a - b;
        });

        for (Integer arr : array) {
            System.out.println(arr);
        }
    }
}
