import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many liters are in the room?");
        int litersinroom = input.nextInt();
        System.out.println("How many liters can bucket 1 take at a time?");
        int bucket1capacity = input.nextInt();
        System.out.println("How many liters can bucket 2 take at a time?");
        int bucket2capacity = input.nextInt();

        int litersinbucket1 = 0;
        int litersinbucket2 = 0;



        while (litersinroom > 0 || litersinbucket1 > 0 || litersinbucket2 > 0) {
            int spaceleftin1 = bucket1capacity-litersinbucket1;
            int spaceleftin2 = bucket2capacity-litersinbucket2;
            System.out.println("The room is now filled with " + litersinroom + "! \nyou have to make it so the room has no water in it and clear the buckets too.");
            System.out.println("Bucket 1 has " + litersinbucket1 + " liters and has room for " + spaceleftin1 + " more liters");
            System.out.println("Bucket 2 has " + litersinbucket2 + " liters and has room for " + spaceleftin2 + " more liters");
            System.out.println("\n\n Controls:\n1.fill bucket 1 from the room");
            System.out.println("2.fill bucket 2 from bucket 1");
            System.out.println("3.clear bucket 2 to the garden");
            System.out.println("\n what are you gonna do?\n");
            char choice = input.next().charAt(0);
            //choice 1
            int canfill = bucket1capacity - litersinbucket1;
            if (choice == '1') {
                if (litersinbucket1 == 0) {
                    litersinbucket1 = bucket1capacity; // sets the bucket to max capacity
                    litersinroom = litersinroom - canfill; //completely fills bucket 1 with the space available
                    System.out.println("filled bucket 1");
                }
                else {
                    System.out.println("Bucket 1 is full! choose something else!");
                }
            }
            //choice 2

            if (choice == '2') {
                if (litersinbucket2 < bucket2capacity) {
                    if (spaceleftin2 <= litersinbucket1) {
                        litersinbucket2 = litersinbucket2 + spaceleftin2; // only fills the amount of liters bucket 2 can take
                        litersinbucket1 = litersinbucket1 - spaceleftin2; //removes the liters that u filled into bucket2
                        spaceleftin2 = 0; // u filled bucket so no space left
                    }
                    if (spaceleftin2 > litersinbucket1) {
                        litersinbucket2 = litersinbucket2 + litersinbucket1;
                        spaceleftin2 -= litersinbucket1;
                        litersinbucket1 = 0;

                    }
                }
                System.out.println("filled bucket 2 from bucket 1!");

            }
            if (choice == '3') {
                litersinbucket2 = 0;
                System.out.println("cleared bucket 2 into the garden!");
            }
        }
    }
}
