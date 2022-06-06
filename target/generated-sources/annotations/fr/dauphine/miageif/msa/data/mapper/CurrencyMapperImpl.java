package fr.dauphine.miageif.msa.data.mapper;

import fr.dauphine.miageif.msa.data.entity.CurrencyEntity;
import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
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
public class CurrencyMapperImpl implements CurrencyMapper {

    @Override
    public CurrencyModel toModel(CurrencyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CurrencyModel currencyModel = new CurrencyModel();

        currencyModel.setId( entity.getId() );
        currencyModel.setSymbol( entity.getSymbol() );
        currencyModel.setDescription( entity.getDescription() );

        return currencyModel;
    }

    @Override
    public CurrencyEntity toEntity(CurrencyModel model) {
        if ( model == null ) {
            return null;
        }

        CurrencyEntity currencyEntity = new CurrencyEntity();

        currencyEntity.setId( model.getId() );
        currencyEntity.setSymbol( model.getSymbol() );
        currencyEntity.setDescription( model.getDescription() );

        return currencyEntity;
    }

    @Override
    public List<CurrencyModel> toCurrencyModelList(List<CurrencyEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CurrencyModel> list1 = new ArrayList<CurrencyModel>( list.size() );
        for ( CurrencyEntity currencyEntity : list ) {
            list1.add( toModel( currencyEntity ) );
        }

        return list1;
    }
}
