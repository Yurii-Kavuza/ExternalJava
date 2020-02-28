package ua.external.base.oop.junittests.sessiontest;

import org.junit.Test;
import ua.external.base.oop.droid.session.Connection;

public class ConnectionTest
{
    @Test
    public void signInTest()
    {
        Connection connection = new Connection();
        connection.signIn();

    }
}
