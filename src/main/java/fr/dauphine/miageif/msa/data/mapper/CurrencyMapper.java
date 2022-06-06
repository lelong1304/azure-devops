package fr.dauphine.miageif.msa.data.mapper;

import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import fr.dauphine.miageif.msa.data.entity.CurrencyEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CurrencyMapper {
    CurrencyModel toModel(CurrencyEntity entity);

    CurrencyEntity toEntity(CurrencyModel model);

    List<CurrencyModel> toCurrencyModelList(List<CurrencyEntity> list);
}
