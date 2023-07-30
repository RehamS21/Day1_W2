import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Question 7: ");

            System.out.println("Hello to the Inventory System");

            ArrayList<Integer> items = new ArrayList<>();
        try{

            do{
                System.out.println("Please choose one of these options \n" +
                        "1. Accept new items \n" +
                        "2. Display items \n" +
                        "3. Search about the available items \n" +
                        "4. Sort items \n" +
                        "5. Exit");
                int user_choose = 0;
                try{
                    user_choose = input.nextInt();
                    checkMenu(user_choose);
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
                if (user_choose == 5) break;
                switch (user_choose){
                    case 1:
                        System.out.println("Enter the items number or -1 to quit : ");
                        int item = input.nextInt();

                        do{
                            if(item == -1) break;
                            try{
                                checkRepeat(items,item);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                break;
                            }
                            items.add(item);
                            System.out.println("Enter the items as number or -1 to exit : ");
                            item = input.nextInt();

                        }while(true);
                        break;
                    case 2:
                        System.out.println("The available items : ");
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println(i+1 +". "+items.get(i));
                        }
                        break;
                    case 3:
                        System.out.println("Enter item number to search about it: ");
                        int item_1 = input.nextInt();
                        boolean not_found = false;
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i)== item_1){
                                System.out.println("The "+ items.get(i) +" available");
                                not_found  = true;
                                break;
                            }
                        }
                        if(! not_found ){
                            System.out.println("Sorry, the "+item_1+ " not found");
                        }
                        break;
                    case 4:
                        try{
                            checkSortArray(items);
                            System.out.println("Sort items : ");
                            Collections.sort(items); // built-in java methods for Arraylist
                            System.out.println(items);
                        }catch (ArrayStoreException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }while(true);
        }catch (InputMismatchException e1){
            System.out.println("Invalid, you must enter numbers");
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public static void checkMenu(int index)throws NumberFormatException{
        if(index > 5){
            throw new NumberFormatException("The number exceed the menu numbers");
        }
    }
    public static void checkSortArray(ArrayList<Integer> array)throws ArrayStoreException{
        if(array.isEmpty()){
            throw new ArrayStoreException("Sorry, your array is empty");
        }
    }
    public static void checkRepeat(ArrayList<Integer> items, int item) throws Exception { // I want to check the items not repeated in array.
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i) == item){
                throw new Exception("The item already added");
            }
        }
    }
}