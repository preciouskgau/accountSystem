//package za.ac.nwu.ac.web.sb.controller;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import za.ac.nwu.ac.domain.service.GeneralResponse;
//
//@RestController
//@RequestMapping("account-type")
//
//public class DemoController {
//    @GetMapping("/all")
//    @ApiOperation(value = "Gets all the configured Account types.", notes = "Return a list of account types")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Account type returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message ="Bad request",response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not found",response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal server Error",response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<String>> getAll()
//    {
//        GeneralResponse<String> response = new GeneralResponse<>(true,"No types found");
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}
