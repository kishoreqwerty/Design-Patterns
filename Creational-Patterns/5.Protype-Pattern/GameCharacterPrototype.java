import java.util.ArrayList;
import java.util.List;

// Prototype interface
interface CharacterPrototype extends Cloneable {
    CharacterPrototype cloneCharacter();
}

// Concrete class implementing Prototype
class GameCharacterPrototype implements CharacterPrototype {

    private String characterClass;
    private int health;
    private int attack;
    private int defense;
    private List<String> abilities;

    // Constructor with initial configuration
    public GameCharacterPrototype(
            String characterClass,
            int health,
            int attack,
            int defense,
            List<String> abilities) {

        this.characterClass = characterClass;
        this.health = health;
        this.attack = attack;
        this.defense = defense;

        // Deep copy for safety
        this.abilities = new ArrayList<>(abilities);
    }

    // Prototype cloning logic
    @Override
    public GameCharacterPrototype cloneCharacter() {

        try {
            GameCharacterPrototype clone =
                    (GameCharacterPrototype) super.clone();

            // Deep copy mutable objects
            clone.abilities = new ArrayList<>(this.abilities);

            return clone;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(
                    "Character cloning failed", e);
        }
    }

    // Modify cloned object
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void addAbility(String ability) {
        abilities.add(ability);
    }

    // Display character details
    public void display() {

        System.out.println("Class: " + characterClass);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Abilities: " + abilities);

        System.out.println();
    }
}

// Driver class
class Main {

    public static void main(String[] args) {

        // Base warrior prototype
        List<String> warriorAbilities =
                List.of("Slash", "Shield Block");

        GameCharacterPrototype warrior =
                new GameCharacterPrototype(
                        "Warrior",
                        100,
                        25,
                        20,
                        warriorAbilities
                );

        // Clone warrior and customize it
        GameCharacterPrototype eliteWarrior =
                warrior.cloneCharacter();

        eliteWarrior.setAttack(40);
        eliteWarrior.addAbility("Berserk");

        // Original object
        System.out.println("Base Character");
        warrior.display();

        // Cloned object
        System.out.println("Cloned Character");
        eliteWarrior.display();
    }
}