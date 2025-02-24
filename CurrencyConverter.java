import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.*; 

public class CurrencyConverter {
    private static final String API_KEY = "b2da337459b6aa2bb94c8d75";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter source currency (e.g., USD, EUR): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., INR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        // Fetch real exchange rate
        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
        if (exchangeRate == -1) {
            System.out.println("Failed to fetch exchange rate. Please check currency codes.");
        } else {
            double convertedAmount = amount * exchangeRate;
            System.out.printf("%.2f %s is %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        }

        scanner.close();
    }

    public static double getExchangeRate(String from, String to) {
        try {
            // Build the API URL
            String urlString = BASE_URL + API_KEY + "/latest/" + from;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read API response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.getString("result").equals("success")) {
                return jsonResponse.getJSONObject("conversion_rates").getDouble(to);
            } else {
                return -1;  // Returning -1 in case the API request fails
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
