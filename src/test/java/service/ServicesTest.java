package service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicesTest {
    private Services _service;

    @BeforeEach
    public void setUp()
    {
        _service = new Services();
    }
    @Test
    @Disabled
    public void successSetTest()
    {
        _service.setDate("18:31:45","GMT"  );
    }

}
