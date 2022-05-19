package valueobjects;

import entities.Attribute;
import exceptions.AttributeBoniException;

import java.util.*;

public final class AttributeBoni {

    final HashMap<String, int> attributeBoni;

    public AttributeBoni(HashMap<String, int> attributeBoni) throws AttributeBoniException {
        if (isValid(attributeBoni)) this.attributeBoni = attributeBoni;
        else throw new AttributeBoniException("Invalid AttributeBoni");
    }

    private boolean isValid(HashMap<String, int> attributeBoni){
        final Set<String> allowedAttributeBoni = new HashSet<>(Arrays.asList(
                Attribute.validAttributeNames
        ));
        Set<String> boniKeys = attributeBoni.keySet();
        return (allowedAttributeBoni.containsAll(boniKeys) && boniKeys.containsAll(allowedAttributeBoni));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeBoni that = (AttributeBoni) o;
        return Objects.equals(attributeBoni, that.attributeBoni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeBoni);
    }

    @Override
    public String toString() {
        return "AttributeBoni{\n" +
                "attributeBoni=" + attributeBoni.toString() +
                "\n}";
    }
}
