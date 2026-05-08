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

public static void main (String[] args){
A.push(4);
A.push(3);
A.push(2);
A.push(1);

    while(!(C.size() == 4 || B.size() == 4)){

System.out.println("A: " + (A.isEmpty() ? "empty" : A));
System.out.println("B: " + (B.isEmpty() ? "empty" : B));
System.out.println("C: " + (C.isEmpty() ? "empty" : C));
System.out.println("Moves: " + MoveCounter);

    Scanner choose = new Scanner(System.in);
System.out.println("Choose something to move");
String input = choose.nextLine();

boolean picked = false;

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
            }
            break;
        case "B":
            if (B.isEmpty() || B.peek() > itemAtTop) {
                B.push(itemAtTop);
                MoveCounter++;
            } else {
                System.out.println("Can't be dropped here");
            }
            break;
        case "C":
            if (C.isEmpty() || C.peek() > itemAtTop) {
                C.push(itemAtTop);
                MoveCounter++;
            } else {
                System.out.println("Can't be dropped here");
            }
            break;
        default:
            System.out.println("Capitalise A B OR C");
    }
}
    }
}
}