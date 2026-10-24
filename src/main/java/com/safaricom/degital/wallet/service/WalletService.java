package com.safaricom.degital.wallet.service;

import com.safaricom.degital.wallet.dto.GeneralResponse;
import com.safaricom.degital.wallet.dto.WalletResponse;
import com.safaricom.degital.wallet.mapper.WalletMapper;
import com.safaricom.degital.wallet.model.Customer;
import com.safaricom.degital.wallet.model.Wallet;
import com.safaricom.degital.wallet.repo.CustomerRepo;
import com.safaricom.degital.wallet.repo.WalletRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepo walletRepo;
    private final CustomerRepo customerRepo;
    private final WalletMapper walletMapper;

    WalletService(WalletRepo walletRepo, CustomerRepo customerRepo, WalletMapper walletMapper) {
        this.walletRepo = walletRepo;
        this.customerRepo = customerRepo;
        this.walletMapper = walletMapper;
    }

    @Transactional
    public ResponseEntity<GeneralResponse<WalletResponse>> createWallet(Long customerId, Wallet wallet) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer == null) {
            return ResponseEntity.status(403).body(
                    new GeneralResponse<>(
                            "Customer with the given id hasn't been found",
                            true,
                            null

                    )
            );
        }
        wallet.setCustomer(customer);
        Wallet savedWallet = walletRepo.save(wallet);

        return ResponseEntity.status(201).body(
                new GeneralResponse<>(
                        "Wallet Created Successfully",
                        true,
                        walletMapper.walletToResponse(wallet)

                )
        );


    }

    public ResponseEntity<GeneralResponse<WalletResponse>> getWallet(Long walletId) {
        Wallet wallet = walletRepo.findById(walletId).orElse(null);
        if (wallet == null) {
            return ResponseEntity.status(403).body(
                    new GeneralResponse<>(
                            "Record not Found",
                            false,
                            null
                    )
            );
        }
        return
                ResponseEntity.status(200).body(
                        new GeneralResponse<>(
                                "Wallet Fetched Successfully",
                                true,
                                walletMapper.walletToResponse(wallet)
                        )
                );
    }

    public ResponseEntity<GeneralResponse<List<WalletResponse>>> getWallets() {
        List<Wallet> wallets = walletRepo.findAll();
        if (wallets.isEmpty()) {
            return ResponseEntity.status(403).body(
                    new GeneralResponse<>(
                            "Record not Found",
                            true,
                            List.of()
                    )
            );
        }
        return ResponseEntity.status(200).body(
                new GeneralResponse<>(
                        "Wallets Successfully fetched",
                        true,
                        walletMapper.walletToResponses(wallets)

                )
        );
    }

    public ResponseEntity<GeneralResponse<List<WalletResponse>>> getWallets(Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer == null) {
            return ResponseEntity.status(403).body(
                    new GeneralResponse<>(
                            "Customer Not Found",
                            false,
                            List.of()
                    )
            );


        }
        List<Wallet> wallets = walletRepo.findAllByCustomerId(customerId);
        if (wallets.isEmpty()) {
            return ResponseEntity.status(403).body(
                    new GeneralResponse<>(
                            "No Wallet Found",
                            true,
                            List.of()
                    )
            );


        }
        return ResponseEntity.status(200).body(
                new GeneralResponse<>(
                        "Successfully Wallets Fetched",
                        true,
                        walletMapper.walletToResponses(wallets)
                )
        );
    }
}


