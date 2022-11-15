package solo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solo.models.Client;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository <Client,Integer> {

    List<Client> findByName(String name);


    List<Client> findByNameOrderByAge (String name);


    List<Client> findByNameStartingWith(String startingWith);


    List<Client> findBySurname(String surname);


    List<Client> findBySurnameStartingWith(String startingWith);




}
