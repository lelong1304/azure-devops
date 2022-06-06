package fr.dauphine.miageif.msa.domain.service;

import fr.dauphine.miageif.msa.data.mapper.CurrencyMapper;
import fr.dauphine.miageif.msa.data.entity.CurrencyEntity;
import fr.dauphine.miageif.msa.data.repository.CurrencyRepository;
import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {
    private CurrencyRepository repository;
    @Autowired
    private CurrencyMapper mapper;

    public CurrencyModel findCurrencyBySymbol(String symbol) {
        CurrencyEntity entity = repository.findBySymbol(symbol);
        return mapper.toModel(entity);
    }

    public List<CurrencyModel> findAll() {
        List<CurrencyEntity> list = repository.findAll();
        return mapper.toCurrencyModelList(list);
    }

    public CurrencyModel create(CurrencyModel currencyModel) {
        CurrencyEntity entity = mapper.toEntity(currencyModel);
        entity = repository.save(entity);
        return mapper.toModel(entity);
    }
}
