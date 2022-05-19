package valueobjects;

import exceptions.PlayerException;

import java.util.Objects;

public final class Player {

    final String firstName;
    final String lastName;

    public Player(String firstName, String lastName) throws PlayerException {
        if (!firstName.equals("")) this.firstName = firstName;
        else throw new PlayerException("Invalid first name");

        if (!lastName.equals("")) this.lastName = lastName;
        else throw new PlayerException("Invalid last name");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
