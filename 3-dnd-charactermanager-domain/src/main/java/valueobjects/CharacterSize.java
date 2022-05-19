package valueobjects;

import exceptions.CharacterSizeException;

import java.util.Objects;

public final class CharacterSize {
    final Character size;

    public CharacterSize(Character size) throws Exception {
        if( size.equals('S') || size.equals('M') || size.equals('L')) this.size = size;
        else throw new CharacterSizeException("Invalid Character Size: " + size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterSize that = (CharacterSize) o;
        return Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return size.toString();
    }
}
