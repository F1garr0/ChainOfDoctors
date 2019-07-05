package laktest;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DocTest {

    @Test
    public void RecognizeTest()
    {
        final String params = "Pain";
        Doc test = new DocStub("Doc");
        String Expected = "Drugs";
        //when(test.Recognize("Pain")).thenReturn("Drugs");
        assertEquals(Expected, test.Recognize("Pain"));
        //when(test.Recognize("Blood")).thenReturn("Bandage");
        Expected = "Bandage";
        assertEquals(Expected, test.Recognize("Blood"));
    }

}
