package com.safaricom.degital.wallet.mapper;

import com.safaricom.degital.wallet.dto.WalletResponse;
import com.safaricom.degital.wallet.model.Wallet;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class WalletMapper {
    public WalletResponse walletToResponse(Wallet wallet){
        return new WalletResponse(
                wallet.getId(),
                wallet.getBalance(),
                wallet.getCurrency(),
                wallet.getCustomer(),
                wallet.getWalletNumber(),
                wallet.getCreatedAt(),
                wallet.getCreatedBy()
        );

    }

    public List<WalletResponse> walletToResponses(List<Wallet> wallets){
        List<WalletResponse> walletResponses = new ArrayList<>();
        for(Wallet wallet : wallets){
            walletResponses.add(walletToResponse(wallet));
        }
        return walletResponses;

    }


}
