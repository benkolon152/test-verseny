import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestMain {
    @Before
    public void testbefore() {
        Main.isRunningtest = true;
    }

    @Test
    public void testMain() throws IOException {
        Main.main(null);
    }

    @Test
    public void testHandler(){
        Tesztversenyhandler handler = new Tesztversenyhandler();

        handler.setValaszok(handler.getValaszok());
    }

    @After
    public void testafter() {
        Main.isRunningtest = false;
    }
}
