package fr.dauphine.miageif.msa.web.controller;
import fr.dauphine.miageif.msa.data.entity.TauxChangeEntity;
import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
import fr.dauphine.miageif.msa.domain.service.CurrencyService;
import fr.dauphine.miageif.msa.domain.service.TauxChangeService;
import fr.dauphine.miageif.msa.web.dto.TauxChangeResponseDto;
import fr.dauphine.miageif.msa.web.mapper.TauxChangeDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rate/")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class ChangeController {

  // Spring se charge de la création d'instance
  @Autowired
  private Environment environment;

  @Autowired
  private TauxChangeService tauxChangeService;
  @Autowired
  private CurrencyService currencyService;
  private TauxChangeDtoMapper mapper;

  @GetMapping("/devise-change/source/{source}/dest/{dest}")
  public List<TauxChangeResponseDto> getTauxChangeBySourceAndDest(@PathVariable String source, @PathVariable String dest){
    List<TauxChangeModel> tauxChanges = tauxChangeService.getTauxChangeBySource(source, dest);
    return mapper.toListReponseDto(tauxChanges);
  }
  @GetMapping("/source/{source}/dest/{dest}")
  public TauxChangeResponseDto getTauxChangeBySourceAndDestToday(@PathVariable String source, @PathVariable String dest){
    TauxChangeModel tauxChange = tauxChangeService.getTauxChangeBySourceToday(source, dest);
    return mapper.toResponseDto(tauxChange);
  }
  @GetMapping("/all")
  public List<TauxChangeResponseDto> getAllChange(){
    List<TauxChangeModel> list = tauxChangeService.getAll();
    return mapper.toListReponseDto(list);
  }

  @GetMapping("/by-date/{date}")
  public  List<TauxChangeResponseDto> getTauxChangeByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    List<TauxChangeModel> list = tauxChangeService.getTauxChangeByDate(date);
    return mapper.toListReponseDto(list);
  }

  @PostMapping("/create")
  public TauxChangeModel create(@RequestBody TauxChangeResponseDto tauxChange) {
    //this code need to be factoring
    TauxChangeModel model = new TauxChangeModel();
    model.setDateExchange(tauxChange.getDateExchange());
    model.setDest(currencyService.findCurrencyBySymbol(tauxChange.getDest()));
    model.setSource(currencyService.findCurrencyBySymbol(tauxChange.getSource()));
    model.setRate(tauxChange.getRate());
    return tauxChangeService.createTauxChange(model);
  }
}