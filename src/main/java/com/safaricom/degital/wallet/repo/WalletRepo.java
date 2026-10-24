package com.safaricom.degital.wallet.repo;

import com.safaricom.degital.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long> {
    List<Wallet> findAllByCustomerId(Long id);
}
