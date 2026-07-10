// Handles CPU related operations
class CPU {

    public void initialize() {
        System.out.println("Initializing CPU...");
    }

    public void startProcessing() {
        System.out.println("CPU started processing instructions.");
    }
}

// Handles memory related operations
class Memory {

    public void loadMemory() {
        System.out.println("Loading data into memory...");
    }
}

// Handles disk operations
class HardDrive {

    public void readBootFiles() {
        System.out.println("Reading boot files from hard drive...");
    }
}

// Handles operating system startup
class OperatingSystem {

    public void startOS() {
        System.out.println("Starting operating system...");
    }
}

// Facade class that hides subsystem complexity
public class ComputerStartupFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private OperatingSystem operatingSystem;

    public ComputerStartupFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
        operatingSystem = new OperatingSystem();
    }

    // Simple method exposed to the client
    public void startComputer() {

        cpu.initialize();

        memory.loadMemory();

        hardDrive.readBootFiles();

        operatingSystem.startOS();

        cpu.startProcessing();

        System.out.println("Computer startup completed successfully.");
    }

    public static void main(String[] args) {

        ComputerStartupFacade computer =
                new ComputerStartupFacade();

        // Client interacts with only one method
        computer.startComputer();
    }
}