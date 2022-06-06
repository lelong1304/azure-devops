package fr.dauphine.miageif.msa.data.mapper;

import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
import fr.dauphine.miageif.msa.data.entity.TauxChangeEntity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TauxChangeMapper {
    TauxChangeModel toModel(TauxChangeEntity entity);

    TauxChangeEntity toEntity(TauxChangeModel model);

    List<TauxChangeModel> toListModel(List<TauxChangeEntity> list);

}
