//package za.ac.nwu.ac.repo.persistence;
//
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import za.ac.nwu.ac.domain.persistence.AccountType;
//import za.ac.nwu.ac.repo.config.RepositoryTestConfig;
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@ContextConfiguration(classes = {RepositoryTestConfig.class})
//public class AccountTypeRepositoryTest {
//
//    @Autowired
//    AccountTypeRepository accountTypeRepository;
//
//    @Before
//    public void setUp() throws Exception
//    {
//
//    }
//
//    @After
//    public void tearDown() throws Exception
//    {
//
//    }
//
//    @Test
//    public void getAccountTypeByMnemonicNativeQueryMiles()
//    {
//        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILES");
//        assertNotNull(miles);
//        assertEquals("MILES",miles.getMnemonic());
//    }
//
//    @Test
//    public void getAccountTypeByMnemonicNativeQuery()
//    {
//        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILESSS");
//        assertNotNull(miles);
//        assertEquals("MILES",miles.getMnemonic());
//    }
//
//
//}
