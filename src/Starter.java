import commands.Command;
import commands.Invoker;
import commands.Receiver;
import commands.impl.*;
import model.Network;

import java.util.Scanner;

/**
 * Created by user on 9/23/2017.
 */
public class Starter {
    public static void main(String[] args) {

        Receiver receiver = new Receiver(new Network());
        Command createNewUserCommand = new CreateNewUserCommand(receiver);
        Command loginCommand = new LoginCommand(receiver);
        Command createPublicMessageCommand = new CreateNewUserCommand(receiver);
        Command createPrivateMessageCommand = new CreatePrivateMessageCommand(receiver);
        Command showAllPublicMessagesCommand = new ShowAllPublicMessagesCommand(receiver);
        Command addFriendCommand = new AddFriendCommand(receiver);


        Invoker invoker = new Invoker();
        boolean exit = false;

         try (Scanner scanner = new Scanner(System.in)) {
             do {

                 System.out.println("Main Menu:");
                 System.out.println("0 - Create a user");
                 System.out.println("1 - Login");
                 System.out.println("2 - Create a public message");
                 System.out.println("3 - Create a private message");
                 System.out.println("4 - Show all public message");
                 System.out.println("5 - Add a friend");
                 System.out.println("666 - exit");
                 int i = scanner.nextInt();

                 switch (i) {
                     case 0: invoker.setCommand(createNewUserCommand);invoker.run();break;
                     case 1: invoker.setCommand(loginCommand);invoker.run();break;
                     case 2: invoker.setCommand(createPublicMessageCommand);invoker.run();break;
                     case 3: invoker.setCommand(createPrivateMessageCommand);invoker.run();break;
                     case 4: invoker.setCommand(showAllPublicMessagesCommand);invoker.run();break;
                     case 5: invoker.setCommand(addFriendCommand);invoker.run();break;
                     case 666: exit = true; break;
                     default: throw new IllegalArgumentException("");
                 }
             }while (!exit);
         }

    }
}
