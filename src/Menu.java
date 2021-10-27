import java.util.ArrayList;
import java.util.Scanner;



public class Menu {

    //Member Attributes

    private String title;
    private ArrayList<String> menuItems;
    private Menu child;
    private Menu parent;
    private Scanner input = new Scanner(System.in);

    public Menu(String title, ArrayList<String> menuItems, Menu child, Menu parent) {
        this.title = title;
        this.menuItems = menuItems;
        this.child = child;
        this.parent = parent;
    }

    //Constructors

    public Menu() {
        this.title = "";
        this.menuItems = new ArrayList<String>();
        this.child = null;
        this.parent = null;
    }

    //Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }

//    public void menuNavigation(){
//        System.out.println(
//                "****************" + this.title + "****************\n\n\n"
//        );
//        for(int i = 0; i < this.menuItems.size() ; i++){
//            System.out.println(
//                    i+1 + ")     " + this.menuItems.get(i)
//            );
//        }
//        System.out.println(this.menuItems.size()+ ')     Go back/exit');
//        int userSelection = input.nextInt();
//        while(userSelection > menuItems.size() || userSelection < 1){
//            System.out.println("Incorrect input, please try again:");
//            userSelection = input.nextInt();
//        }
//
//
//    }



}
