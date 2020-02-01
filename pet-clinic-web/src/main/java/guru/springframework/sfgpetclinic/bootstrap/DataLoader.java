package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Trent");
        owner1.setLastName("Reznor");
        owner1.setAddress("123 Astreet");
        owner1.setCity("Acity");
        owner1.setTelephone("1234123412");

        Pet trentsPet = new Pet();
        trentsPet.setPetType(savedDogPetType);
        trentsPet.setOwner(owner1);
        trentsPet.setBirthDate(LocalDate.now());
        trentsPet.setName("Rufus");
        owner1.getPets().add(trentsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maynard");
        owner2.setLastName("Keenan");
        owner2.setAddress("123 AnotherStreet");
        owner2.setCity("Acity");
        owner2.setTelephone("1234123412");

        Pet maynardsPet = new Pet();
        maynardsPet.setPetType(savedCatPetType);
        maynardsPet.setOwner(owner1);
        maynardsPet.setBirthDate(LocalDate.now());
        maynardsPet.setName("Scratchy");
        owner2.getPets().add(maynardsPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr");
        vet1.setLastName("DooLittle");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr");
        vet2.setLastName("DooNothing");

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}
