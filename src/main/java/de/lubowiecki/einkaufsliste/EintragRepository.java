package de.lubowiecki.einkaufsliste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional, da JpaRepository bereits die Annotation enthält
public interface EintragRepository extends JpaRepository<Eintrag, Integer> {
}
