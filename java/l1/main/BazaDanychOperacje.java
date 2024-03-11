package l1.main;

/*
*	 To jest interfejs zawierający podstawowe operacje na bazie danych, które będą współdzielone przez poszczególne klasy,
*	 będące tabelami bazodanowymi, ponieważ na każdej tabeli powinniśmy móc wykonywać operacje zapisu, usuwania i wyświetlania danych
*	 Metody są abstrakcyjne, poprzedzone słowami kluczowymi public abstract, nie mają w interfejsie implementacji.
*	 Implementacja jest możliwa na poziomie klasy abstrakcyjnej lub zwykłej klasy, która implementuje interfejs.
*/
public interface BazaDanychOperacje<T> { //interfejs ten będzie w parametrach przyjmować typ generyczny w celu umożliwienia
    //* zdefiniowania zestawu operacji, które mogą być implementowane dla różnych rodzajów(typów) danych.
     void zapiszDoTabeli(T obiekt);
     void usunZTabeli(T obiekt);
     void wyswietlDaneNaKonsoliZTabeli();
}
