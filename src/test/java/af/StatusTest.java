package af;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StatusTest {
    @Test
    public void differentMessagesShouldReturnRightStatusString() {
        assertThat(Status.getStatus("stable"), is(Status.OK));
        assertThat(Status.getStatus("back to normal"), is(Status.OK));
        assertThat(Status.getStatus("1 test is still failing"), is(Status.FAIL));
        assertThat(Status.getStatus("1 test failure"), is(Status.FAIL));
        assertThat(Status.getStatus("broken since build #133"), is(Status.FAIL));
        assertThat(Status.getStatus("broken since this build"), is(Status.FAIL));
    }

}