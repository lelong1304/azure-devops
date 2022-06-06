package fr.dauphine.miageif.msa.data.repository;
import fr.dauphine.miageif.msa.data.entity.TauxChangeEntity;
import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// Creation du JPA Repository basé sur Spring Data
//  Permet de "générer" toutes sortes de requêtes JPA, sans implementation
@Repository
public interface TauxChangeRepository extends  JpaRepository<TauxChangeEntity, Long>{
  // Query Method findBy
  @Query("SELECT t FROM TauxChangeEntity t WHERE t.source.symbol = :source AND t.dest.symbol = :dest")
  List<TauxChangeEntity> findBySourceAndDest(String source, String dest);

  @Query("SELECT t FROM TauxChangeEntity t WHERE t.source.symbol = :source AND t.dest.symbol = :dest ORDER BY t.dateExchange DESC ")
  List<TauxChangeEntity> findBySourceAndDestSort(String source, String dest);

//  TauxChangeEntity findFirstBySourceAndDest(CurrencyModel source, CurrencyModel dest);
  @Query("SELECT t FROM TauxChangeEntity t WHERE t.dateExchange between :date and :date2")
  List<TauxChangeEntity> findByDate(Date date, Date date2);
}