package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository)
    {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes()
    {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try
        {
            for(AccountType accountType : accountTypeRepository.findAll())
            {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return  accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        return null;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic)
    {
        try
        {
            AccountType accountType;
            accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(accountType);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
//    @Override
//    public AccountTypeDto create(AccountTypeDto accountTypeDto)
//    {
//        try
//        {
//            AccountType accountType;
//            accountType = accountTypeRepository.save(AccountTypeDto.getAccountType());
//            return new AccountTypeDto(accountType);
//        }
//        catch (Exception e)
//        {
//                throw new RuntimeException("Unable to read from the DB", e);
//        }
//    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {
        try
        {
            AccountType accountType;
            accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }

    @Override
    public AccountTypeDto getAccountTypeByDtoMnemonic(String mnemonic) {
        try
        {
            return(accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic));
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read the DB");
        }
    }

    @Override
    public AccountTypeDto deleteAccountType(AccountTypeDto accountTypeDto) {
        return null;
    }

    @Override
    public void someMethod() {

    }


}
