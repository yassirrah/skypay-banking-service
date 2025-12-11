# Banking Service

Implementation of the Skypay banking service.

## Features

- `Account` with:
    - `deposit(int amount, LocalDate date)`
    - `withdraw(int amount, LocalDate date)`
    - `printStatement()` – prints history from latest to oldest
- Input validation with exceptions:
    - `IllegalArgumentException` for invalid amounts / null dates
    - `IllegalStateException` for insufficient balance
- Uses `int` for money
- Stores transactions in an `ArrayList<Transaction>`

Statement date format: `dd/MM/yyyy`.

## Run
- The entry point of the application is the `Main` class:
- Package: `org.skypay.bankingservice`
- File path: `src/main/java/org/skypay/bankingservice/Main.java`
```bash
./mvnw clean compile
./mvnw exec:java -Dexec.mainClass="org.skypay.bankingservice.Main"
```
## How to run tests

The project uses JUnit 5 for unit tests.

To run all tests from the command line, execute from the project root:

```bash
./mvnw test