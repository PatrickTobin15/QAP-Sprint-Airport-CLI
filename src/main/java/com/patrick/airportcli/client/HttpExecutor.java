package com.patrick.airportcli.client;

import java.io.IOException;

// wraps a GET request so it can be mocked in tests
public interface HttpExecutor {

    String get(String url) throws IOException, InterruptedException;
}
