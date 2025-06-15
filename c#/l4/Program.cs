using System;
using System.Collections.Generic;
using System.Linq;

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
        void ILogger.Log(string message)
        {
            Console.WriteLine($"ILogger log: {message}");
        }

        void IEmailSender.Log(string message)
        {
            Console.WriteLine($"IEmailSender log: {message}");
        }

        public void Log(string message)
        {
            Console.WriteLine($"Direct EmailLogger log: {message}");
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
                Console.WriteLine(
                    $"Vehicle Type: {vehicle.GetType().Name}, Max Speed: {vehicle.MaxSpeed}, Max Passengers: {vehicle.MaxPassengers}"
                );
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

        public Book(
            string title,
            string author,
            DateTime publicationDate,
            decimal price,
            string description
        )
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

        public void AddBook(IBook book) => Books.Add(book);

        public void RemoveBook(IBook book) => Books.Remove(book);

        public void UpdateBook(IBook oldBook, IBook newBook)
        {
            int index = Books.IndexOf(oldBook);
            if (index != -1)
                Books[index] = newBook;
        }

        public List<IBook> FindBooksByAuthor(string author) =>
            Books.Where(b => b.Author.Equals(author, StringComparison.OrdinalIgnoreCase)).ToList();

        public List<IBook> FindBooksByTitle(string title) =>
            Books.Where(b => b.Title.Equals(title, StringComparison.OrdinalIgnoreCase)).ToList();

        public List<IBook> FindBooksByPublicationDate(DateTime publicationDate) =>
            Books.Where(b => b.PublicationDate.Year == publicationDate.Year).ToList();

        public List<IBook> FindBooksByPrice(decimal price) =>
            Books.Where(b => b.Price == price).ToList();

        public override string ToString() =>
            string.Join(Environment.NewLine, Books.Select(b => b.ToString()));
    }

    class Program
    {
        static void Main(string[] args)
        {
            ILibrary library = new Library();

            while (true)
            {
                Console.WriteLine("\n--- MENU ---");
                Console.WriteLine("1. Email Logger");
                Console.WriteLine("2. Vehicle Trip");
                Console.WriteLine("3. Library Management");
                Console.WriteLine("0. Exit");
                Console.Write("Choose an option: ");
                if (!int.TryParse(Console.ReadLine(), out int choice) || choice < 0 || choice > 3)
                {
                    Console.WriteLine("Invalid choice, try again.");
                    continue;
                }

                switch (choice)
                {
                    case 1:
                        EmailLogger emailLogger = new EmailLogger();
                        ILogger logger = emailLogger;
                        IEmailSender sender = emailLogger;

                        logger.Log("Logger interface log");
                        sender.Log("EmailSender interface log");
                        emailLogger.Log("Direct EmailLogger log");
                        emailLogger.SendEmail("Sending actual email");
                        break;

                    case 2:
                        Trip trip = new Trip();
                        trip.AddVehicle(new Car());
                        trip.AddVehicle(new Bus());
                        trip.AddVehicle(new Plane());
                        trip.ShowTripDetails();
                        break;

                    case 3:
                        ManageLibrary(library);
                        break;

                    case 0:
                        return;
                }
            }
        }

        static void ManageLibrary(ILibrary library)
        {
            while (true)
            {
                Console.WriteLine("\n-- Library Menu --");
                Console.WriteLine("1. Add Book");
                Console.WriteLine("2. Remove Book");
                Console.WriteLine("3. Update Book");
                Console.WriteLine("4. Show All Books");
                Console.WriteLine("5. Find by Author");
                Console.WriteLine("6. Find by Title");
                Console.WriteLine("7. Find by Publication Year");
                Console.WriteLine("8. Find by Price");
                Console.WriteLine("0. Back");

                Console.Write("Select: ");
                string input = Console.ReadLine();
                if (input == "0")
                    break;

                switch (input)
                {
                    case "1":
                        library.AddBook(ReadBookInput());
                        break;
                    case "2":
                        Console.Write("Enter title to remove: ");
                        var title = Console.ReadLine();
                        var bookToRemove = library.FindBooksByTitle(title).FirstOrDefault();
                        if (bookToRemove != null)
                            library.RemoveBook(bookToRemove);
                        else
                            Console.WriteLine("Book not found.");
                        break;
                    case "3":
                        Console.Write("Enter title of book to update: ");
                        var oldTitle = Console.ReadLine();
                        var oldBook = library.FindBooksByTitle(oldTitle).FirstOrDefault();
                        if (oldBook != null)
                        {
                            var newBook = ReadBookInput();
                            library.UpdateBook(oldBook, newBook);
                        }
                        else
                            Console.WriteLine("Book not found.");
                        break;
                    case "4":
                        Console.WriteLine(library.ToString());
                        break;
                    case "5":
                        Console.Write("Enter author: ");
                        var author = Console.ReadLine();
                        PrintBooks(library.FindBooksByAuthor(author));
                        break;
                    case "6":
                        Console.Write("Enter title: ");
                        PrintBooks(library.FindBooksByTitle(Console.ReadLine()));
                        break;
                    case "7":
                        Console.Write("Enter year: ");
                        if (int.TryParse(Console.ReadLine(), out int year))
                            PrintBooks(
                                library.FindBooksByPublicationDate(new DateTime(year, 1, 1))
                            );
                        break;
                    case "8":
                        Console.Write("Enter price: ");
                        if (decimal.TryParse(Console.ReadLine(), out decimal price))
                            PrintBooks(library.FindBooksByPrice(price));
                        break;
                    default:
                        Console.WriteLine("Invalid option.");
                        break;
                }
            }
        }

        static IBook ReadBookInput()
        {
            Console.Write("Title: ");
            var title = Console.ReadLine();
            Console.Write("Author: ");
            var author = Console.ReadLine();
            Console.Write("Publication Date (yyyy-mm-dd): ");
            DateTime.TryParse(Console.ReadLine(), out var date);
            Console.Write("Price: ");
            decimal.TryParse(Console.ReadLine(), out var price);
            Console.Write("Description: ");
            var desc = Console.ReadLine();

            return new Book(title, author, date, price, desc);
        }

        static void PrintBooks(List<IBook> books)
        {
            if (books.Count == 0)
                Console.WriteLine("No books found.");
            else
                books.ForEach(b => Console.WriteLine(b));
        }
    }
}
