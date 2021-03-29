package us.mattgreen;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    public UserInput(){

    }

    void addAnimal(ArrayList zoo){
        boolean miceParsed = false;
        boolean friendlyParsed = false;
        boolean ageParsed = false;
        boolean isFriendly = false;
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        int miceKilled = 0;
        int friendly = 0;
        int age = 0;
        System.out.println("What type of animal would you like to add to the zoo?");
        System.out.println("1. Cat\n2. Dog\n3. Teacher");
        try{
            choice = Integer.parseInt(keyboard.nextLine());
        }catch(Exception e){
            addAnimal(zoo);
        }
        switch (choice){
            case 1:

                while(miceParsed == false) {
                    System.out.println("How many mice has this cat killed?");
                    try {
                        miceKilled = Integer.parseInt(keyboard.nextLine());
                        miceParsed = true;
                    } catch (NumberFormatException e) {
                        miceParsed = false;
                    }

                }
                System.out.println("What is this cat's name?");
                String name = keyboard.nextLine();
                Cat cat = new Cat(miceKilled, name);
                zoo.add(cat);
                break;

            case 2:

                while(friendlyParsed == false) {
                    System.out.println("Is this dog friendly?\n1. Yes\n2. No");
                    try {
                        friendly = Integer.parseInt(keyboard.nextLine());
                        friendlyParsed = true;
                        if(friendly == 1){
                            isFriendly = true;
                        }
                        else{
                            isFriendly = false;
                        }
                    } catch (NumberFormatException e) {
                        friendlyParsed = false;
                    }

                }
                System.out.println("What is this dog's name?");
                String dogName = keyboard.nextLine();
                Dog dog = new Dog(isFriendly, dogName);
                zoo.add(dog);
                break;

            case 3:

                while(ageParsed == false) {
                    System.out.println("What is this teacher's age?");
                    try {
                        age = Integer.parseInt(keyboard.nextLine());
                        ageParsed = true;
                    } catch (NumberFormatException e) {
                        ageParsed = false;
                    }
                }
                System.out.println("What is this teacher's name?");
                String personName = keyboard.nextLine();
                Teacher teacher = new Teacher(age, personName) {
                };
                zoo.add(teacher);
                break;
        }
    }
}
