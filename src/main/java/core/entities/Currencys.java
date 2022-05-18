package core.entities;

import java.util.Objects;
import java.util.UUID;

public class Currencys {

    private int CP;
    private int SP;
    private int EP;
    private int GP;
    private int PP;
    private UUID id;

    public Currencys(int CP, int SP, int EP, int GP, int PP) {
        this.CP = CP;
        this.SP = SP;
        this.EP = EP;
        this.GP = GP;
        this.PP = PP;
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currencys currencys = (Currencys) o;
        return id.equals(currencys.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public void setEP(int EP) {
        this.EP = EP;
    }

    public void setGP(int GP) {
        this.GP = GP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public int getCP() {
        return CP;
    }

    public int getSP() {
        return SP;
    }

    public int getEP() {
        return EP;
    }

    public int getGP() {
        return GP;
    }

    public int getPP() {
        return PP;
    }
}
