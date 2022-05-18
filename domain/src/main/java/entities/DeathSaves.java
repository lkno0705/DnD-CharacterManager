package entities;

import java.util.Arrays;
import java.util.UUID;

public class DeathSaves {

    private Boolean[] successes;
    private Boolean[] failures;
    private int successPointer = 0;
    private int failurePointer = 0;
    private final UUID id;

    public DeathSaves() {
        successes = new Boolean[3];
        failures = new Boolean[3];
        this.id = UUID.randomUUID();
    }

    public void reset(){
        successes = new Boolean[3];
        failures = new Boolean[3];
        successPointer = 0;
        failurePointer = 0;
    }

    public void setSuccess(){
        successes[successPointer] = true;
        successPointer++;
    }

    public void setFailure(){
        failures[failurePointer] = true;
        failurePointer++;
    }

    public int getFailures(){
        return (int) Arrays.stream(failures)
                .filter(c -> c!=null && c)
                .count();
    }

    public int getSuccesses(){
        return (int) Arrays.stream(successes)
                .filter(c -> c!=null && c)
                .count();
    }




}
