
//* ten interfejs powstał tylko poto aby w klasie accounting działało nie tylko na contractedPerson 
//* tylko na wszystkich klasach gdzie istnieje metoda print i paymentValue
public interface interfaceContractedObject {
    void print();

    double paymentValue();
}
