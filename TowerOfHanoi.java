//Tower of hanoi
//create 3 stacks A,B,C
//FIll Stack A with 1,2,3,4
//When program runs, display all 3 stacks ⬇️
//prompt user to momve all items from stack A to B or C by moving a single item per turn⬇️
//items can only be placed on larger items; 3 cant be placed in a stack if the last item inside the stack is 2
//display a move counter next to the 3 stacks, increment after every move. dont increment after an illegal move
//Game is finished when all items are sorted in stack B or C
/*   !Tower of Hanoi!   */

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi{
static Stack<Integer> A = new Stack<>();
static Stack<Integer> B = new Stack<>();
static Stack<Integer> C = new Stack<>();
static int itemAtTop = 0;
static int MoveCounter = 0;
static Scanner choose = new Scanner(System.in);
static boolean picked = false;
static String input = "";
static int level = 0;

static void initiation() {
    boolean ready = false;
    while (!ready) {
        System.out.println("Welcome to Tower of Hanoi. What level would you like to play?");
        level = choose.nextInt();
        choose.nextLine();
        int perfectScore = (int) Math.pow(2, level) - 1;
        System.out.println("Perfect score is " + perfectScore + " moves. Proceed? (yes/no)");
        String answer = choose.nextLine();
        if (answer.equals("yes")) {
            ready = true;
        }
    }
    for (int i = level; i > 0; i--) {
        A.push(i);
    }
}
//Display the stacks and move counter
static void display() {
System.out.println("A: " + (A.isEmpty() ? "empty" : A));
System.out.println("B: " + (B.isEmpty() ? "empty" : B));
System.out.println("C: " + (C.isEmpty() ? "empty" : C));
System.out.println("Moves: " + MoveCounter);
}
//pick an item
static void pick() {
System.out.println("Choose something to move");
input = choose.nextLine();

switch(input) {
    case "A":
        if (A.isEmpty()) {
            System.out.println("That stack is empty!");
        } else {
            itemAtTop = A.peek();
            A.pop();
            picked = true;
        }
        break;
    case "B":
        if (B.isEmpty()) {
            System.out.println("That stack is empty!");
        } else {
            itemAtTop = B.peek();
            B.pop();
            picked = true;
        }
        break;
    case "C":
        if (C.isEmpty()) {
            System.out.println("That stack is empty!");
        } else {
            itemAtTop = C.peek();
            C.pop();
            picked = true;
        }
        break;
    default:
        System.out.println("Capitalise A B OR C");
}
}
//place the item
static void place() {
    if (picked) {
    System.out.println("Choose a column to drop it");
    String drop = choose.nextLine();
    while(drop.equals(input)) {
        System.out.println("Choose a different stack!");
        drop = choose.nextLine();
    }
    switch(drop) {
        case "A":
            if (A.isEmpty() || A.peek() > itemAtTop) {
                A.push(itemAtTop);
                MoveCounter++;
            } else {
    System.out.println("Can't be dropped here");
    if (input.equals("A")) A.push(itemAtTop);
    else if (input.equals("B")) B.push(itemAtTop);
    else if (input.equals("C")) C.push(itemAtTop);
}
            break;
        case "B":
            if (B.isEmpty() || B.peek() > itemAtTop) {
                B.push(itemAtTop);
                MoveCounter++;
            } else {
    System.out.println("Can't be dropped here");
    if (input.equals("A")) A.push(itemAtTop);
    else if (input.equals("B")) B.push(itemAtTop);
    else if (input.equals("C")) C.push(itemAtTop);
}
            break;
        case "C":
            if (C.isEmpty() || C.peek() > itemAtTop) {
                C.push(itemAtTop);
                MoveCounter++;
            } else {
                System.out.println("Can't be dropped here");
                if (input.equals("A")) A.push(itemAtTop);
                else if (input.equals("B")) B.push(itemAtTop);
                else if (input.equals("C")) C.push(itemAtTop);
            }
            break;
        default:
            System.out.println("Capitalise A B OR C");
            if (input.equals("A")) A.push(itemAtTop);
            else if (input.equals("B")) B.push(itemAtTop);
            else if (input.equals("C")) C.push(itemAtTop);
    }
}
picked = false;
}



public static void main (String[] args){

initiation();

    while(!(C.size() == level || B.size() == level)){
display();
pick();
place();
}
    System.out.println("You win! It took you " + MoveCounter + " moves!");
}
}