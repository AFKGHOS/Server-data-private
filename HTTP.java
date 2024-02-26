import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class MyServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(null, 8080);

        server.createContext("/store", new StoreHandler());
        server.setExecutor(null); // Creates a default executor

        server.start();
    }

    static class StoreHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Implementați aici logica de stocare a datelor în baza de date
            String response = "Date stocate cu succes!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
