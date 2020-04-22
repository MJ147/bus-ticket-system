package pl.connectis.programator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.connectis.programator.util.DataGenerator;

/*

TODO    -zamodelowac klienta
TODO    -zamodelowac pracownika
TODO    -zamodelowac bilet (rozne warianty: ulgowy, studencki, normalny, senior)
TODO    -zamodelowac trase przejazdu
TODO    -jako pracownik mam możliwość zarejestrować klienta
TODO    -jako user mam możliwość stworzyć konto
TODO    -jako klient mam możliwość kupienia biletu na daną trasę
TODO    -jako pracownik mam możliwość wyświetlić klientów
TODO    -jako klient mam możliwość wyświetlić połączenia
TODO    -jako klient mam możliwość wyświetlić wszystkie dostępne bilety
TODO    -jako pracownik mam możliwość dodać nowy przejazd
TODO    -jako pracownik mam możliwość modyfikować dane klientów
TODO    -jako pracownik mam możliwość sprzedać bilet klientowi
 */

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
