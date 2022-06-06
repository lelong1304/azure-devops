package fr.dauphine.miageif.msa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.dauphine.miageif.msa.data.entity.CurrencyEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
    public CurrencyEntity findBySymbol(String symbol);
}
