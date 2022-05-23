package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeathSavesTest {

    DeathSaves deathSaves;

    @BeforeEach
    public void setup(){
        this.deathSaves = new DeathSaves();
        deathSaves.setSuccess();
        deathSaves.setFailure();
        deathSaves.setSuccess();
    }

    @Test
    void getFailures() {
        assertEquals(1, this.deathSaves.getFailures());
    }

    @Test
    void getSuccesses() {
        assertEquals(2, this.deathSaves.getSuccesses());
    }
}