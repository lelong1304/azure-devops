package fr.dauphine.miageif.msa.web.mapper;

import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
import fr.dauphine.miageif.msa.web.dto.TauxChangeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TauxChangeDtoMapper {

    @Mapping(source = "model.source.symbol", target = "source")
    @Mapping(source = "model.dest.symbol", target = "dest" )
    TauxChangeResponseDto toResponseDto(TauxChangeModel model);

    List<TauxChangeResponseDto> toListReponseDto(List<TauxChangeModel> list);

}
