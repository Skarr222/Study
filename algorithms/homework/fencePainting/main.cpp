/*
 * Bajtek postanowił pomalować płot. Płot składa się z n sąsiednich desek ustawionych pionowo. Postanowił
 * rozłożyć pracę na m dni. Każdego dnia wykonuje jedną z dwóch czynności:
 * 1. Pokrywa warstwą farby spójny kawałek płotu.
 * 2. Zastanawia się iloma warstwami farby pomalował już daną deskę.
 * Niestety zadanie trochę go przerosło i będzie potrzebował Twojej pomocy.
 *
 * Wejście
 * W pierwszym wierszu wejścia znajdują się dwie liczby całkowite n, m (1 ≤ n, m ≤ 105), odpowiednio liczba
 * desek w płocie i liczba dni pracy.
 * W kolejnych m wierszach znajdują się informacje o kolejnych dniach. Pierwsza liczba w wierszu oznacza, którą
 * czynność danego dnia wykonuje (1 - malowanie, 2 - liczenie warstw). Jeśli jest to pierwsza czynność, to następnie
 * występują dwie liczby całkowite li, ri (1 ≤ li ≤ ri ≤ n), oznaczające malowanie desek o numerach pomiędzy
 * li i ri włącznie. Jeśli jest to druga czynność, to następnie jest jeszcze jedna liczba całkowita ai (1 ≤ ai ≤ n),
 * oznaczająca, że Bajtek zastanawia się iloma wartami pokrył deskę o numerze ai.
 *
 * Wyjście
 * Na wyjściu dla każdego zapytania typu drugiego należy wypisać w oddzielnych wierszach odpowiedź (liczbę
 * warstw).
 *
 *
 * Wejście
 * 5 6
 * 1 2 4
 * 2 3
 * 1 3 5
 * 2 4
 * 2 2
 * 2 5
 *
 * WYJŚCIE
 * 1
 * 2
 * 1
 * 1
 *
 */