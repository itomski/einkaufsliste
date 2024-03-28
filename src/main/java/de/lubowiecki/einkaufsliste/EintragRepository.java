package de.lubowiecki.einkaufsliste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EintragRepository extends JpaRepository<Eintrag, Integer> { // Zweiter Typ ist der Typ der id
}
