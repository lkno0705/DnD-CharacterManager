package entities;

import exceptions.CurrencyException;

import java.util.Objects;
import java.util.UUID;

public class Currencys {

    private int CP;
    private int SP;
    private int EP;
    private int GP;
    private int PP;
    private UUID id;

    public Currencys(int CP, int SP, int EP, int GP, int PP) throws CurrencyException {
        if(CP > 0) this.CP = CP;
        else throw new CurrencyException("Invalid CP: " + CP);

        if(SP > 0) this.SP = SP;
        else throw new CurrencyException("Invalid SP: " + SP);

        if(EP > 0) this.EP = EP;
        else throw new CurrencyException("Invalid EP: " + EP);

        if(GP > 0) this.GP = GP;
        else throw new CurrencyException("Invalid GP: " + GP);

        if(PP > 0) this.PP = PP;
        else throw new CurrencyException("Invalid PP: " + PP);
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
