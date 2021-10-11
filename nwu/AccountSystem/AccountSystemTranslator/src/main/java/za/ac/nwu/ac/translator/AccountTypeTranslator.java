package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);
    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);


    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeByDtoMnemonic(String mnemonic);

    AccountTypeDto deleteAccountType(AccountTypeDto accountTypeDto);
    void someMethod();

}
