public class ExceptionProgram1 {
    public static void main(String[] args){
        try{
            /*ArrayIndexOutOfBoundsException*/
            int[] a = {1,2,3};
            System.out.println(a[3]);

            /*NullPointerException*/
            String s = null;
            System.out.println(s.length());

            /*ArithmeticException*/
            int result = 10/0;
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception Occurs");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBounds Exception Occurs");
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException Occurs");
        }
    }
}
