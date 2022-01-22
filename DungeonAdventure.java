import java.util.Random;
import java.util.Scanner;

public class DungeonAdventure {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // enemy
        String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 50;

        // player
        int health = 100;
        int attackDamage = 50;
        int numHealthPotion = 2;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("\n\tWelcome to the Dungeon!");
        System.out.println("-----------------------------------------------");
        System.out.print("\tEnter Your name: ");
        String player = in.nextLine();

        GAME: while (running) {

            System.out.println("-----------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t" + enemy + " appeared! \n");

            while (enemyHealth > 0) {
                System.out.println("\t" + player + "'s HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tYou would like to");
                System.out.println("\t1. Attack the enemy.");
                System.out.println("\t2. Drink health Potion");
                System.out.println("\t3. Run from the enemy");
                System.out.print("\tEnter Your choice: ");
                String input = in.nextLine();

                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\n\t> " + player + " strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println(
                            "\t> " + player + " receives " + damageTaken + " damage in retaliation from " + enemy + "");

                    if (health < 1) {
                        System.out.println(
                                "\n\t> " + player + " has taken too much damage," + player + " is too weak to go on!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotion > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotion--;
                        System.out.println("\n\t> " + player + " drink the health potion.\n\tHealing yourself for "
                                + healthPotionHealAmount + "." + "\n\t> " + player + " now have " + health + " HP."
                                + "\n\t" + numHealthPotion + " Health Potions left. \n");
                    } else {
                        System.out.println(
                                "\n\tYou have no health potions left!\n\tDefeat enemies for a chance to go on!\n");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\n\t" + player + " ran away from the " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("\n\tInvalid command!");
                }
            }

            if (health < 1) {
                System.out.println("\t> " + player + " limp out of the dungeon, weak from battle.");
                break;
            }

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("\t" + enemy + " was defeated by " + player + ".");
            System.out.println("\t" + player + " has " + health + " HP's left.");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotion++;
                System.out.println("\t" + enemy + " dropped a health potion! ");
                System.out.println("\tYou now have " + numHealthPotion + " health potion's.");
            }

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("\n\tWhat would you like to do now?");
            System.out.println("\t1. Continue fighting");
            System.out.println("\t2. Exit dungeon");

            System.out.print("\tEnter Your Choice: ");
            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("\tInvalid command");
                System.out.print("\tEnter Your Choice: ");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("\n\t" + player + " continued his adventure!");
            } else if (input.equals("2")) {
                System.out.println("\n\t" + player + " exit the dungeon.");
                break;
            }
        }

        System.out.println("\t*------------------------------*");
        System.out.println("\t*-Thanks for playing " + player + "!-*");
        System.out.println("\t*------------------------------*");

    }
}