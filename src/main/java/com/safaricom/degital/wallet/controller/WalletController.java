package com.safaricom.degital.wallet.controller;

import com.safaricom.degital.wallet.dto.GeneralResponse;
import com.safaricom.degital.wallet.dto.WalletResponse;
import com.safaricom.degital.wallet.model.Wallet;
import com.safaricom.degital.wallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    private final WalletService walletService;
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<GeneralResponse<WalletResponse>> createWallet(
            @PathVariable Long customerId,
            @Valid @RequestBody Wallet wallet
    ){
        return walletService.createWallet(customerId,wallet);
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<GeneralResponse<List<WalletResponse>>> getWallets(
            @PathVariable Long customerId
    ){
        return walletService.getWallets(customerId);
    }
    @GetMapping
    public ResponseEntity<GeneralResponse<List<WalletResponse>>> getWallets(

    ){
        return walletService.getWallets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse<WalletResponse>> getWallet(
@PathVariable Long id
    ){
        return walletService.getWallet(id);
    }
}
