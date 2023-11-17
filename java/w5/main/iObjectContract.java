package w5.main;

// Ten interfejs jest po to, żeby mógł drukować umowy nie tylko na projekty, ale na sprzedaż i usługi.
// Ten interfejs jest po to, żeby w klasie Contract działała funkcja printContract nie tylko na projekcie.
// Ponieważ funkcja printContract w klasie Contract używa danych funkcji data, calculate to interfejs musi mieć te funkcje.
// Wszystkie obiekty klas które, beda dziedziczyły po iObjectContract (implementowały),
// i beda miały funkcje Dane i Wycena, beda mogły mieć wydrukowana umowę.
// Wszystkie klasy, które będą dziedziczyły po iObjectContract będą miały funkcje data i calculate.

interface iObjectContract {
    void data();
    double calculate();
}
