package fr.dauphine.miageif.msa.web.mapper;

import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
import fr.dauphine.miageif.msa.web.dto.TauxChangeResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T02:05:56+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (AdoptOpenJDK)"
)
@Component
public class TauxChangeDtoMapperImpl implements TauxChangeDtoMapper {

    @Override
    public TauxChangeResponseDto toResponseDto(TauxChangeModel model) {
        if ( model == null ) {
            return null;
        }

        TauxChangeResponseDto tauxChangeResponseDto = new TauxChangeResponseDto();

        tauxChangeResponseDto.setSource( modelSourceSymbol( model ) );
        tauxChangeResponseDto.setDest( modelDestSymbol( model ) );
        tauxChangeResponseDto.setId( model.getId() );
        tauxChangeResponseDto.setRate( model.getRate() );
        tauxChangeResponseDto.setDateExchange( model.getDateExchange() );

        return tauxChangeResponseDto;
    }

    @Override
    public List<TauxChangeResponseDto> toListReponseDto(List<TauxChangeModel> list) {
        if ( list == null ) {
            return null;
        }

        List<TauxChangeResponseDto> list1 = new ArrayList<TauxChangeResponseDto>( list.size() );
        for ( TauxChangeModel tauxChangeModel : list ) {
            list1.add( toResponseDto( tauxChangeModel ) );
        }

        return list1;
    }

    private String modelSourceSymbol(TauxChangeModel tauxChangeModel) {
        if ( tauxChangeModel == null ) {
            return null;
        }
        CurrencyModel source = tauxChangeModel.getSource();
        if ( source == null ) {
            return null;
        }
        String symbol = source.getSymbol();
        if ( symbol == null ) {
            return null;
        }
        return symbol;
    }

    private String modelDestSymbol(TauxChangeModel tauxChangeModel) {
        if ( tauxChangeModel == null ) {
            return null;
        }
        CurrencyModel dest = tauxChangeModel.getDest();
        if ( dest == null ) {
            return null;
        }
        String symbol = dest.getSymbol();
        if ( symbol == null ) {
            return null;
        }
        return symbol;
    }
}
