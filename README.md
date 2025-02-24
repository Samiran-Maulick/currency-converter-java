# Currency Converter

## Overview

This is a simple Currency Converter program written in Java that fetches real-time exchange rates from an online API. It allows users to convert any amount from one currency to another using live exchange rates.

## Features

- Converts an entered amount from one currency to another.

- Fetches real-time exchange rates from ExchangeRate-API.

- Uses org.json library to parse API responses.

- Runs in the command line without requiring an IDE.

## Prerequisites

- Java 21+ (Ensure you have Java installed and added to your system PATH).

- Internet Connection (Required for fetching exchange rates).

- org.json Library (Download the JAR file from Maven Repository).

## Installation

1. Download and install Java if you haven’t already.

2. Download the org.json library and place it in the project folder.

3. Compile the program using CMD:
javac -cp ".;json-20250107.jar" CurrencyConverter.java

4. Run the program:
java -cp ".;json-20250107.jar" CurrencyConverter

## Usage

1. Run the program.

2. Enter the amount to be converted.

3. Enter the source currency code (e.g., USD, EUR).

4. Enter the target currency code (e.g., INR, GBP).

5. The program will fetch the latest exchange rate and display the converted amount.

## Example Output

Enter amount: 100  

Enter source currency (e.g., USD, EUR): USD

Enter target currency (e.g., INR, GBP): INR

100.00 USD is 8300.50 INR

## License

This project is for educational purposes and is free to use.

## Author

Created by Samiran Maulick. Contributions and improvements are welcome!
