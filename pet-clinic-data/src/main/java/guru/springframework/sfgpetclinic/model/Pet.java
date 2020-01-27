package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet {

    private PetType perType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getPerType() {
        return perType;
    }

    public void setPerType(PetType perType) {
        this.perType = perType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
