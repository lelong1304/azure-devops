package fr.dauphine.miageif.msa.data.mapper;

import fr.dauphine.miageif.msa.data.entity.CurrencyEntity;
import fr.dauphine.miageif.msa.data.entity.TauxChangeEntity;
import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
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
public class TauxChangeMapperImpl implements TauxChangeMapper {

    @Override
    public TauxChangeModel toModel(TauxChangeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TauxChangeModel tauxChangeModel = new TauxChangeModel();

        tauxChangeModel.setId( entity.getId() );
        tauxChangeModel.setSource( currencyEntityToCurrencyModel( entity.getSource() ) );
        tauxChangeModel.setDest( currencyEntityToCurrencyModel( entity.getDest() ) );
        tauxChangeModel.setRate( entity.getRate() );
        tauxChangeModel.setDateExchange( entity.getDateExchange() );

        return tauxChangeModel;
    }

    @Override
    public TauxChangeEntity toEntity(TauxChangeModel model) {
        if ( model == null ) {
            return null;
        }

        TauxChangeEntity tauxChangeEntity = new TauxChangeEntity();

        tauxChangeEntity.setId( model.getId() );
        tauxChangeEntity.setSource( currencyModelToCurrencyEntity( model.getSource() ) );
        tauxChangeEntity.setDest( currencyModelToCurrencyEntity( model.getDest() ) );
        tauxChangeEntity.setRate( model.getRate() );
        tauxChangeEntity.setDateExchange( model.getDateExchange() );

        return tauxChangeEntity;
    }

    @Override
    public List<TauxChangeModel> toListModel(List<TauxChangeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TauxChangeModel> list1 = new ArrayList<TauxChangeModel>( list.size() );
        for ( TauxChangeEntity tauxChangeEntity : list ) {
            list1.add( toModel( tauxChangeEntity ) );
        }

        return list1;
    }

    protected CurrencyModel currencyEntityToCurrencyModel(CurrencyEntity currencyEntity) {
        if ( currencyEntity == null ) {
            return null;
        }

        CurrencyModel currencyModel = new CurrencyModel();

        currencyModel.setId( currencyEntity.getId() );
        currencyModel.setSymbol( currencyEntity.getSymbol() );
        currencyModel.setDescription( currencyEntity.getDescription() );

        return currencyModel;
    }

    protected CurrencyEntity currencyModelToCurrencyEntity(CurrencyModel currencyModel) {
        if ( currencyModel == null ) {
            return null;
        }

        CurrencyEntity currencyEntity = new CurrencyEntity();

        currencyEntity.setId( currencyModel.getId() );
        currencyEntity.setSymbol( currencyModel.getSymbol() );
        currencyEntity.setDescription( currencyModel.getDescription() );

        return currencyEntity;
    }
}
