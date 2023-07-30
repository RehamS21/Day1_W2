// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();
        ArrayList<Double> last_result = new ArrayList<>();
        int num1 = 0;
        int num2 = 0;
        int close_menu = 0;
        int user_option = 0;
        System.out.println("Welcome to Calculator System");


        try {

            do {
                System.out.println("From 1-10 choose one of the options : \n" + "1. Addition the numbers\n" +
                        "2. subtraction the numbers \n" + "3. multiplication the numbers\n" + "4. division the numbers\n" +
                        "5. modulus the numbers \n" + "6. minimum number \n" + "7. maximum number \n" + "8. average of numbers\n" +
                        "9. Last result in calculator \n" + "10. List of all results in calculator \n");
                    user_option = input.nextInt();
                    checkMenue(user_option);


                switch (user_option) {
                    case 1:
                        System.out.println("Enter the number1 : ");
                        num1 = input.nextInt();
                        System.out.println("Enter the number2 : ");
                        num2 = input.nextInt();
                        int add = Calc.Addition(num1, num2);
                        System.out.println("The addition = " + add);
                        history.add("You sum the " + num1 + " + " + num2 + " = " + add);
                        last_result.add(Double.valueOf(add));
                        break;

                    case 2:
                        System.out.println("Enter the number1 : ");
                        num1 = input.nextInt();
                        System.out.println("Enter the number2 : ");
                        num2 = input.nextInt();
                        int sub = Calc.subtraction(num1, num2);
                        System.out.println("The subtraction = " + sub);
                        history.add("You subtraction of " + num1 + " - " + num2 + " = " + sub);
                        last_result.add(Double.valueOf(sub));
                        break;

                    case 3:
                        System.out.println("Enter the number1 : ");
                        num1 = input.nextInt();
                        System.out.println("Enter the number2 : ");
                        num2 = input.nextInt();
                        int mult = Calc.multiplication(num1, num2);
                        System.out.println("The multiplication = " + mult);
                        history.add("You multiplication of " + num1 + " * " + num2 + " = " + mult);
                        last_result.add(Double.valueOf(mult));
                        break;

                    case 4:
                        try {
                            System.out.println("Enter the number1 : ");
                            num1 = input.nextInt();
                            System.out.println("Enter the number2 : ");
                            num2 = input.nextInt();
                            checkZero(num2);
                            double dev = Calc.division(num1, num2);
                            System.out.println("The division = " + dev);
                            history.add("You division of " + num1 + " / " + num2 + "  = " + dev);
                            last_result.add(dev);
                        }catch (ArithmeticException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            System.out.println("Enter the number1 : ");
                            num1 = input.nextInt();
                            System.out.println("Enter the number2 : ");
                            num2 = input.nextInt();
                            checkZero(num2);
                            int mod = Calc.modulus(num1, num2);
                            System.out.println("The modulus = " + mod);
                            history.add("You modulus of " + num1 + " % " + num2 + "  = " + mod);
                            last_result.add(Double.valueOf(mod));
                        }catch (ArithmeticException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("Enter the number1 : ");
                        num1 = input.nextInt();
                        System.out.println("Enter the number2 : ");
                        num2 = input.nextInt();
                        int min_num = Calc.min(num1, num2);
                        System.out.println("The minimum = " + min_num);
                        history.add("Minimum of " + num1 + " < " + num2 + "  = " + min_num);
                        last_result.add(Double.valueOf(min_num));
                        break;

                    case 7:
                        System.out.println("Enter the number1 : ");
                        num1 = input.nextInt();
                        System.out.println("Enter the number2 : ");
                        num2 = input.nextInt();
                        int max_num = Calc.max(num1, num2);
                        System.out.println("The Minimum = " + max_num);
                        history.add("Minimum of " + num1 + " > " + num2 + " = " + max_num);
                        last_result.add(Double.valueOf(max_num));
                        break;

                    case 8:
                        System.out.println("Enter the number1 : ");
                        num1 = input.nextInt();
                        System.out.println("Enter the number2 : ");
                        num2 = input.nextInt();
                        double ave = Calc.average(num1, num2);
                        System.out.println("The average = " + ave);
                        history.add("average of " + num1 + " and " + num2 + "s = " + ave);
                        last_result.add(ave);
                        break;
                    case 9:
                        Calc.Terminate_9(last_result);
                        close_menu =1;
                        break;
                    case 10:
                        Calc.Terminate_10(history);
                        close_menu =1;
                        break;

                }
            } while (close_menu ==0);

        }catch (InputMismatchException e1){
            System.out.println("Invalid, you must enter numbers");
        } catch (Exception e2){
            System.out.println(e2.getMessage());
        }

    }

    public static void checkMenue(int index)throws Exception{
        if(index > 10){
            throw new Exception("Invalid number.Please enter number exist in menu");
        }
    }

    public static void checkZero(int num2)throws ArithmeticException{
        if(num2 == 0){
            throw new ArithmeticException("The second number 0, you can't divide by 0 for division operation or modulus ");
        }
    }

    public static void checkHistory(ArrayList<String> history)throws Exception{
        if(history.isEmpty()){
            throw new Exception("Your history is empty");
        }
    }

    public static void checkLastresult(ArrayList<Double> last_result)throws Exception{
        if(last_result.isEmpty()){
            throw new Exception("You didn't add any calculation");
        }
    }


}


