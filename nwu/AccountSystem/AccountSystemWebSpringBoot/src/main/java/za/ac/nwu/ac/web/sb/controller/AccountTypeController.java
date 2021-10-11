package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@Component
@RequestMapping("account-type")

public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    private final ModifyAccountTypeFlow modifyAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,@Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow, ModifyAccountTypeFlow modifyAccountTypeFlow)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
        this.modifyAccountTypeFlow = modifyAccountTypeFlow;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Return a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account type returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message ="Bad request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server Error",response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true,accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account type was successfully created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message ="Bad request",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server Error",response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.", required = true)
            @RequestBody AccountTypeDto accountType)
    {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetch the specified AccountType.",notes = "Fetch the AccountType corresponding to the mnemonic. ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Goal found", response = GeneralResponse.class),
        @ApiResponse(code = 400, message ="Bad request",response = GeneralResponse.class),
        @ApiResponse(code = 404, message = "Resource Not found",response = GeneralResponse.class),
        @ApiResponse(code = 500, message = "Internal server Error",response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value= "The mnemonic that unlovely identifies the AccountType.",
            example = "MILES",
            name = "mnemonic",
            required = true)
            @PathVariable("mnemonic") final String mnemonic)
    {
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Delete the specified AccountType.",notes = "Delete the AccountType corresponding to the mnemonic. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account deleted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message ="Bad request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server Error",response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> deleteAccountType(
            @ApiParam(value= "The mnemonic that unlovely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
           @PathVariable("mnemonic") final String mnemonic){
         AccountTypeDto accountType = modifyAccountTypeFlow.deleteAccountType(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping({"mnemonic"})
    @ApiOperation(value = "Updates the specified AccountType.",notes = "Updates the AccountType corresponding to the mnemonic. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message ="Bad request",response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server Error",response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
            @ApiParam(value= "The mnemonic that unlovely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic,
            @ApiParam(value = "The new AccountTypeName that the specified AccountType should be updated with.",
            name = "newAccountTypeName",
            required = true)
            @RequestParam("newAccountTypeName") final String newAccountTypeName,

            @ApiParam(value = "The optional new date with which to updated the creationDate is ISO date format (yyyy-MM-dd)\r\n",
                    name = "newCreationDate")
            @RequestParam(value = "CreationDate",required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate newCreationDate
            )
    {
        AccountTypeDto accountType = modifyAccountTypeFlow.updateAccountType(mnemonic,newAccountTypeName,newCreationDate);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response,HttpStatus.OK);


    }

}


