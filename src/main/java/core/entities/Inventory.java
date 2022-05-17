package core.entities;

import java.util.HashMap;
import java.util.UUID;

public class Inventory {

    private Currencys currencys;
    private HashMap<String, Integer> items;
    private UUID id;

    public Inventory() {
        this.id = UUID.randomUUID();
    }
}
