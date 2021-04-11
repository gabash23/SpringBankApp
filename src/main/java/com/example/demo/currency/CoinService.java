package com.example.demo.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CoinService {

    private final HolderRepository holderRepository;

    @Autowired
    public CoinService(HolderRepository holderRepository) {
        this.holderRepository = holderRepository;
    }

    public List<Holder> getCoins() {
        return holderRepository.findAll();
    }

    public void addNewHolder(Holder holder) throws UsernameInUseException {
        Optional<Holder> holderByEmail = holderRepository.findHolderByUsername(holder.getName());
        if (holderByEmail.isPresent()) {
            throw new UsernameInUseException("Username already exists in the database");
        }

        holderRepository.save(holder);

        System.out.println(holder);
    }

    public void deleteHolder(Long holderId) throws NotInDatabaseException {
        if (!holderRepository.existsById(holderId)) {
            throw new NotInDatabaseException("User was not found in the database with id " + holderId);
        }
        holderRepository.deleteById(holderId);
    }

    @Transactional
    public void updateHolder(Long holderId, String username, Integer money) throws NotInDatabaseException, UsernameInUseException {
        Holder holder = holderRepository.findById(holderId)
                .orElseThrow(() -> new NotInDatabaseException(
                        String.format("Holder with id %d does not exist", holderId)
                ));

        if (username != null && username.length() > 0 && !Objects.equals(holder.getUsername(), username)) {
            Optional<Holder> holderOptional = holderRepository.findHolderByUsername(username);
            if(holderOptional.isPresent()) {
                throw new UsernameInUseException(String.format("Username: %s is taken", username));
            }
            holder.setName(username);
        }

        if (money != null && !Objects.equals(holder.getMoney(), money)) {
            holder.setMoney(money);
        }
    }
}
