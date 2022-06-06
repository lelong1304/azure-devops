package fr.dauphine.miageif.msa.domain.service;

import fr.dauphine.miageif.msa.data.entity.TauxChangeEntity;
import fr.dauphine.miageif.msa.data.mapper.TauxChangeMapper;
import fr.dauphine.miageif.msa.data.repository.TauxChangeRepository;
import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TauxChangeService {
    @Autowired
    private TauxChangeRepository repository;
    @Autowired
    private CurrencyService currencyService;

    private TauxChangeMapper mapper;

    public List<TauxChangeModel> getTauxChangeBySource(String source, String dest) {
        List<TauxChangeEntity> entities = repository.findBySourceAndDest(source, dest);
        return mapper.toListModel(entities);
    }
    /*
    public TauxChangeModel getTauxChangeBySourceToday(String source, String dest) {
        Date today = new Date();
        CurrencyModel currency_src = currencyService.findCurrencyBySymbol(source);
        CurrencyModel currency_dest = currencyService.findCurrencyBySymbol(dest);
        TauxChangeEntity entity = repository.findFirstBySourceAndDest(currency_src, currency_dest);
        return mapper.toModel(entity);
    }*/
    public TauxChangeModel getTauxChangeBySourceToday(String source, String dest) {
        List<TauxChangeEntity> entities = repository.findBySourceAndDestSort(source, dest);
        TauxChangeEntity entity = entities.get(0);
        return mapper.toModel(entity);
    }
        public List<TauxChangeModel> getAll() {
        List<TauxChangeEntity> list = repository.findAll();
        return mapper.toListModel(list);
    }
    public TauxChangeModel createTauxChange(TauxChangeModel tauxChange) {
        TauxChangeEntity entity = mapper.toEntity(tauxChange);
        entity = repository.save(entity);
        return mapper.toModel(entity);
    }

    public List<TauxChangeModel> getTauxChangeByDate(Date date) {
        List<TauxChangeModel> models = new ArrayList<>();
        Date date2 = new Date();
        date2.setTime(date.getTime() + 86400000); // add 1 day = 86400000 ms
        List<TauxChangeEntity> entities = repository.findByDate(date, date2);
        for (TauxChangeEntity e: entities) {
            models.add(mapper.toModel(e));
        }
        return models;
    }


}
