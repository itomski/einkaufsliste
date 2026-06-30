package de.lubowiecki.einkaufsliste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // optional, da JpaRepository bereits die Annotation enthält
public interface EintragRepository extends JpaRepository<Eintrag, Integer> {

    List<Eintrag> findByErledigt(boolean erledigt);

}
