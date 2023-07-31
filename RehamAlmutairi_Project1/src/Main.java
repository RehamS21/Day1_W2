// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static String [][] game = new String[3][3];
    public static ArrayList<String> user_index = new ArrayList<>();
    public static ArrayList<String> computer_index = new ArrayList<>();

    public static boolean close_game = false;



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                game[i][j] =" ";
            }
        }
        Board_form(game);

        int index = 0;
        int index_2 = 0;
        do{
            try {
                System.out.println("Where would you like to play ? (1-9)");
                index = input.nextInt();
                checkOutOfRange(index);
                index_2 = checkPlace(index, "user");
                board_move(index_2);
                user_index.add(String.valueOf(index_2));
                Board_form(game);
                if(!iswinner()) break; // when user win in the last index of array.
            }catch (InputMismatchException e1){
                System.out.println("Invalid input, you must enter numbers ");
                break;
            }
            catch (Exception e2){
                System.out.println(e2.getMessage());
                break;
            }

            int rand = random.nextInt(9 - 1 + 1) + 1;

            int check_repeat = checkPlace(rand,"computer");
            if(close_game) break;
            board_move(check_repeat, "O");
            computer_index.add(String.valueOf(check_repeat));
            System.out.println("Computer Choose : "+ check_repeat);
            Board_form(game);
        }while(iswinner());
    }

    public static void Board_form(String [][] game){
        System.out.println(game[0][0]+"|"+game[0][1]+"|"+game[0][2]);
        System.out.println("-+-+-");
        System.out.println(game[1][0]+"|"+game[1][1]+"|"+game[1][2]);
        System.out.println("-+-+-");
        System.out.println(game[2][0]+"|"+game[2][1]+"|"+game[2][2]);
    }

    public static int checkPlace(int place , String idntity){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        if (idntity.equalsIgnoreCase("user")){
            while(user_index.contains(String.valueOf(place)) || computer_index.contains(String.valueOf(place)))
            {
                System.out.println("This place already taken");
                System.out.println("Where would you like to play ? (1-9)");
                try {
                    place = input.nextInt();
                    checkOutOfRange(place);
                }catch (InputMismatchException e1){
                    System.out.println("Invalid input, you must enter numbers ");
                    break;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    break;
                }
            }
            return place;
        }else{
            while(user_index.contains(String.valueOf(place)) || computer_index.contains(String.valueOf(place)))
            {
                try{
                    place = random.nextInt(9 - 1 + 1) + 1;
                    no_win(place);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    break;
                }

            }
            return place;
        }
    }
    public static void board_move(int move) {
        board_move(move, "X");
    }
    public static void board_move(int move, String x_or_o){
            switch(move){
                case 1:
                    game[0][0] = x_or_o;
                    break;
                case 2:
                    game[0][1] = x_or_o;
                    break;
                case 3:
                    game[0][2] = x_or_o;
                    break;
                case 4:
                    game[1][0] = x_or_o;
                    break;
                case 5:
                    game[1][1] = x_or_o;
                    break;
                case 6:
                    game[1][2] = x_or_o;
                    break;
                case 7:
                    game[2][0] = x_or_o;
                    break;
                case 8:
                    game[2][1] = x_or_o;
                    break;
                case 9:
                    game[2][2] = x_or_o;
                    break;
            }
    }


    public static boolean iswinner(){
        String win_user ="";
        String win_computer = "";
        boolean flag_1 = true;
        boolean flag_2 = false;
        try {

        }catch(Exception e){}
        // check by rows
        for(int i = 0 ; i < game.length ; i++){
            for (int j = 0; j < game.length; j++) {
                if(game[i][j].equalsIgnoreCase("X")){
                    win_user += "X";
                }
                if(game[i][j].equalsIgnoreCase("O")){
                    win_computer +="O";
                }
            }
            if(win_user.equalsIgnoreCase("XXX")){
                System.out.println("You Win");
                flag_1 = false;
                break;
            }else if(win_computer.equalsIgnoreCase("OOO")){
                System.out.println("Computer Win");
                flag_1 = false;
                break;
            }else{
                win_user = "";
                win_computer ="";
            }


            flag_2 = true;
        }


        // check by columns
        if(flag_2 == true){
            for (int i = 0; i < game.length; i++) {
                if((!game[0][i].equals(" ")) && (game[0][i].equalsIgnoreCase(game[1][i])) && (game[1][i].equalsIgnoreCase(game[2][i]))){
                    if(game[0][i].equals("X")){
                        System.out.println("You Win !");
                    }else System.out.println("Computer Win !");

                    flag_1 = false;
                    break;
                }
            }
        }
        // check the matrix
        if((!game[0][0].equals(" ")) && (game[0][0].equalsIgnoreCase(game[1][1])) && (game[1][1].equalsIgnoreCase(game[2][2]))){
            if(game[0][0].equals("X")){
                System.out.println("You Win !");
            }else System.out.println("Computer Win !");

            flag_1 = false;
        }else if((!game[0][2].equals(" ")) && (game[0][2].equalsIgnoreCase(game[1][1])) && (game[1][1].equalsIgnoreCase(game[2][0]))){
            if(game[0][2].equals("X")){
                System.out.println("You Win !");
            }else System.out.println("Computer Win !");

            flag_1 = false;
        }

        return flag_1;
    }

    public static void checkOutOfRange(int place) throws Exception{
        if(!(place > 0 && place < 10)){
            throw new Exception("Sorry, the number out of range. You must enter number from 1-9");
        }
    }

    public static void no_win(int place) throws Exception{
        if((computer_index.size() == 4) && (user_index.contains(String.valueOf(place)) || computer_index.contains(String.valueOf(place)))){
            close_game = true;
           throw new Exception("No Win !");
        }
    }



}
