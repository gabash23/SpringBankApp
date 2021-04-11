package com.example.demo.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/coin")
public class CoinController {

    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping
    public List<Holder> getCoins() {
        return coinService.getCoins();
    }

    @PostMapping
    public void registerNewHolder(@RequestBody Holder holder) throws UsernameInUseException {
        coinService.addNewHolder(holder);
    }

    @PutMapping(path = "{holderId}")
    public void updateHolder(
            @PathVariable("holderId") Long holderId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer money) throws NotInDatabaseException, UsernameInUseException {
        coinService.updateHolder(holderId, username, money);
    }


    @DeleteMapping(path = "{holderId}")
    public void deleteHolder(@NonNull @PathVariable("holderId") Long holderId) throws NotInDatabaseException {
        coinService.deleteHolder(holderId);
    }
}
