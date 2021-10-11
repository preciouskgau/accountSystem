package za.ac.nwu.ac.logic.flow.impl;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModuleTest {
    private Modulo mod;

    @Before
    public void setUP() throws Exception
    {
        mod = new Modulo();
    }

    @Test
    public void testMod() throws Exception {
        Integer result = mod.doMod(9,5);
        assertNotNull("Should not be null",result);
        assertEquals("should be value 4",4,result.intValue());
    }

    @Test()
    public void testModBy0() {
        try
        {
            mod.doMod(9,0);
            fail("Should throw an Exception");
        }
        catch (Exception e)
        {
            assertTrue("Error message not as expected",e.getMessage().equalsIgnoreCase("Some reason"));
        }

    }
}
