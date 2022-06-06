package fr.dauphine.miageif.msa.web.controller;
import fr.dauphine.miageif.msa.data.mapper.CurrencyMapper;
import fr.dauphine.miageif.msa.domain.model.CurrencyModel;
import fr.dauphine.miageif.msa.domain.model.TauxChangeModel;
import fr.dauphine.miageif.msa.domain.service.CurrencyService;
import fr.dauphine.miageif.msa.domain.service.TauxChangeService;
import fr.dauphine.miageif.msa.web.dto.TauxChangeResponseDto;
import fr.dauphine.miageif.msa.web.mapper.TauxChangeDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("currency/")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class CurrencyController {

  // Spring se charge de la création d'instance
  @Autowired
  private Environment environment;

  @Autowired
  private CurrencyService currencyService;

  @GetMapping("/all")
  public List<CurrencyModel> getAll() {
    List<CurrencyModel> list = currencyService.findAll();
    return list;
  }

  @PostMapping("/create")
  public CurrencyModel create(@RequestBody CurrencyModel currencyModel) {
    return currencyService.create(currencyModel);
  }
}