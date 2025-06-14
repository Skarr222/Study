/*
* 1. Utwórz dwa interfejsy ILogger oraz IEmailSender definiujące metodę Log. Utwórz również klasę
* EmailLogger implementującą obydwa interfejsy oraz definiujące własną metodę Log. W
* rozwiązaniu koniecznie załącz kod wywołujący wszystkie trzy metody na instancji klasy.
* 2. Stwórz abstrakcyjną klasę Vehicle, która zawiera właściwości abstrakcyjne, takie jak MaxSpeed i
* MaxPassengers, które określają maksymalną prędkość i liczbę pasażerów, jakie pojazd może
* pomieścić. Następnie stwórz klasy dziedziczące po Vehicle, takie jak Car, Bus i Plane, które
* implementują właściwości MaxSpeed i MaxPassengers w zależności od swojego typu pojazdu.
* Następnie stwórz klasę Trip, która przechowuje listę pojazdów i pozwala na wyświetlenie
* maksymalnej prędkości i liczby pasażerów dla każdego pojazdu na wycieczce.
* 3. Załóżmy, że chcemy stworzyć program do zarządzania listą książek w bibliotece. Książki mogą być
* dodawane, usuwane, modyfikowane i wyświetlane. Chcemy również umożliwić sortowanie
* książek według różnych kryteriów, takich jak autor, tytuł i data wydania. Aby ułatwić korzystanie
* z programu, zdefiniujemy interfejsy IBook i ILibrary, które będą reprezentować książki,
* bibliotekę.
* Twoim zadaniem jest zdefiniowanie klas Book i Library, które będą implementowały te interfejsy,
*  o raz stworzenie programu, który umożliwi użytkownikowi zarządzanie listą książek w bibliotece.
*  Zdefiniuj interfejs IBook, który będzie zawierał następujące właściwości i metody:
* • Title - właściwość typu string, zwracająca tytuł książki.
* • Author - właściwość typu string, zwracająca nazwisko autora książki.
* • PublicationDate - właściwość typu DateTime, zwracająca datę wydania książki.
* • Price - właściwość typu decimal, zwracająca cenę książki.
* • Description - właściwość typu string, zwracająca opis książki.
* • ToString() - metoda zwracająca tekstową reprezentację książki.
* Zdefiniuj interfejs ILibrary, który będzie zawierał następujące właściwości i metody:
* • Books - właściwość typu List<IBook>, zwracająca listę książek w bibliotece.
* • AddBook(IBook book) - metoda dodająca książkę do biblioteki.
* • RemoveBook(IBook book) - metoda usuwająca książkę z biblioteki.
* • UpdateBook(IBook oldBook, IBook newBook) - metoda modyfikująca książkę w bibliotece.
* • FindBooksByAuthor(string author) - metoda zwracająca listę książek napisanych przez
* danego autora.
* • FindBooksByTitle(string title) - metoda zwracająca listę książek o danym tytule.
* • FindBooksByPublicationDate(DateTime publicationDate) - metoda zwracająca listę książek
* wydanych w danym roku.
* • FindBooksByPrice(decimal price) - metoda zwracająca listę książek o danej cenie.
* • ToString() - metoda zwracająca tekstową reprezentację biblioteki. 
*/

namespace L4
{
    interface ILogger
    {
        void Log(string message);
    }
    interface IEmailSender
    {
        void Log(string message);
    }

    class EmailLogger : ILogger, IEmailSender
    {
        public void Log(string message)
        {
            Console.WriteLine($"Log from EmailLogger: {message}");
        }

        public void SendEmail(string message)
        {
            Console.WriteLine($"Sending email with message: {message}");
        }
    }
    abstract class Vehicle
    {
        public abstract int MaxSpeed { get; }
        public abstract int MaxPassengers { get; }
    }
    class Car : Vehicle
    {
        public override int MaxSpeed => 200;
        public override int MaxPassengers => 5;
    }
    class Bus : Vehicle
    {
        public override int MaxSpeed => 100;
        public override int MaxPassengers => 50;
    }
    class Plane : Vehicle
    {
        public override int MaxSpeed => 900;
        public override int MaxPassengers => 300;
    }

    class Trip
    {
        private List<Vehicle> vehicles = new List<Vehicle>();

        public void AddVehicle(Vehicle vehicle)
        {
            vehicles.Add(vehicle);
        }

        public void ShowTripDetails()
        {
            foreach (var vehicle in vehicles)
            {
                Console.WriteLine($"Vehicle Type: {vehicle.GetType().Name}, Max Speed: {vehicle.MaxSpeed}, Max Passengers: {vehicle.MaxPassengers}");
            }
        }
    }

    interface IBook
    {
        string Title { get; }
        string Author { get; }
        DateTime PublicationDate { get; }
        decimal Price { get; }
        string Description { get; }
        string ToString();
    }

    interface ILibrary
    {
        List<IBook> Books { get; }
        void AddBook(IBook book);
        void RemoveBook(IBook book);
        void UpdateBook(IBook oldBook, IBook newBook);
        List<IBook> FindBooksByAuthor(string author);
        List<IBook> FindBooksByTitle(string title);
        List<IBook> FindBooksByPublicationDate(DateTime publicationDate);
        List<IBook> FindBooksByPrice(decimal price);
        string ToString();
    }

    class Book : IBook
    {
        public string Title { get; private set; }
        public string Author { get; private set; }
        public DateTime PublicationDate { get; private set; }
        public decimal Price { get; private set; }
        public string Description { get; private set; }

        public Book(string title, string author, DateTime publicationDate, decimal price, string description)
        {
            Title = title;
            Author = author;
            PublicationDate = publicationDate;
            Price = price;
            Description = description;
        }

        public override string ToString()
        {
            return $"{Title} by {Author}, published on {PublicationDate.ToShortDateString()}, Price: {Price:C}, Description: {Description}";
        }
    }

    class Library : ILibrary
    {
        public List<IBook> Books { get; private set; } = new List<IBook>();

        public void AddBook(IBook book)
        {
            Books.Add(book);
        }

        public void RemoveBook(IBook book)
        {
            Books.Remove(book);
        }

        public void UpdateBook(IBook oldBook, IBook newBook)
        {
            int index = Books.IndexOf(oldBook);
            if (index != -1)
            {
                Books[index] = newBook;
            }
        }

        public List<IBook> FindBooksByAuthor(string author)
        {
            return Books.Where(b => b.Author.Equals(author, StringComparison.OrdinalIgnoreCase)).ToList();
        }

        public List<IBook> FindBooksByTitle(string title)
        {
            return Books.Where(b => b.Title.Equals(title, StringComparison.OrdinalIgnoreCase)).ToList();
        }

        public List<IBook> FindBooksByPublicationDate(DateTime publicationDate)
        {
            return Books.Where(b => b.PublicationDate.Year == publicationDate.Year).ToList();
        }

        public List<IBook> FindBooksByPrice(decimal price)
        {
            return Books.Where(b => b.Price == price).ToList();
        }

        public override string ToString()
        {
            return string.Join(Environment.NewLine, Books.Select(b => b.ToString()));
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            int choice;

            while (true)
            {
                Console.WriteLine("1. Email Logger");
                Console.WriteLine("2. Vehicle Trip");
                Console.WriteLine("3. Library Management");
                Console.WriteLine("0. Exit");
                Console.Write("Choose an option: ");
                if (!int.TryParse(Console.ReadLine(), out choice) || choice < 0 || choice > 3)
                {
                    Console.WriteLine("Invalid choice, please try again.");
                    continue;
                }
                switch (opcja = Convert.ToInt32(Console.ReadLine()))
                {
                    case 1:
                        // Email Logger
                        EmailLogger emailLogger = new EmailLogger();
                        emailLogger.Log("This is a log message.");
                        emailLogger.SendEmail("This is an email message.");
                        break;

                    case 2:
                        // Vehicle Trip
                        Trip trip = new Trip();
                        trip.AddVehicle(new Car());
                        trip.AddVehicle(new Bus());
                        trip.AddVehicle(new Plane());
                        trip.ShowTripDetails();
                        break;

                    case 3:
                        // Library Management
                        Library library = new Library();
                        library.AddBook(new Book("C# Programming", "John Doe", new DateTime(2020, 1, 1), 29.99m, "A comprehensive guide to C# programming."));
                        library.AddBook(new Book("Learning ASP.NET", "Jane Smith", new DateTime(2021, 5, 15), 39.99m, "An introduction to ASP.NET development."));
                        Console.WriteLine(library.ToString());
                        break;

                    case 0:
                        return;

                    default:
                        Console.WriteLine("Invalid choice, please try again.");
                        break;
                        

                }
            }
        }
    }

}