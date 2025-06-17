/*
1. Napisz program w języku C#, który będzie symulować bazę danych pracowników w firmie. Każdy
pracownik będzie reprezentowany przez klasę Employee, która będzie przechowywać podstawowe
dane o pracowniku, takie jak identyfikator, imię, nazwisko i stanowisko.
Zadanie polega na utworzeniu klasy EmployeeDatabase, która będzie zawierać następujące metody:
 AddEmployee(int id, string firstName, string lastName, string position): Metoda ta powinna
dodawać nowego pracownika do bazy danych. Metoda powinna przyjmować identyfikator
(id), imię (firstName), nazwisko (lastName) oraz stanowisko (position) pracownika,
 RemoveEmployee(int id): Metoda ta powinna usuwać pracownika z bazy danych na
podstawie podanego identyfikatora (id),
 GetEmployee(int id): Metoda ta powinna zwracać pracownika o podanym identyfikatorze
(id).
„Silnik” bazy danych powinien działać w oparciu o klasę Dictionary.
2. Napisz program w języku C#, który będzie symulować system zarządzania zamówieniami w sklepie
internetowym. Wykorzystaj klasę HashSet<T> do przechowywania unikalnych zamówień.
Twoje zadanie polega na utworzeniu klasy OrderManagementSystem, która będzie zawierać
następujące metody:
 PlaceOrder(int orderId, string customerName): Metoda ta powinna przyjmować
identyfikator zamówienia (orderId) oraz nazwę klienta (customerName) i dodawać nowe
zamówienie do systemu,
 CancelOrder(int orderId): Metoda ta powinna anulować zamówienie na podstawie
podanego identyfikatora (orderId),
 DisplayOrders(): Metoda ta powinna wyświetlać listę wszystkich zamówień w systemie,
 TotalOrders(): Metoda ta powinna zwracać liczbę wszystkich zamówień w systemie.
3. Napisz program w języku C#, który będzie symulować system kontroli biletów komunikacji
miejskiej. Zaimplementuj klasę TicketChecker, która będzie służyć do sprawdzania, czy dany
jednorazowy bilet został już wykorzystany.
Twoje zadanie polega na napisaniu klasy TicketChecker z następującymi metodami:
 AddTicket(string ticketCode): Metoda ta powinna dodawać nowy bilet o podanym kodzie
(ticketCode) do listy sprawdzanych biletów,
 CheckTicket(string ticketCode): Metoda ta powinna sprawdzać, czy dany bilet o podanym
kodzie (ticketCode) został już wykorzystany. Metoda powinna zwracać true, jeśli bilet nie
został jeszcze wykorzystany, oraz false, jeśli bilet został już sprawdzony wcześniej.
 ClearTickets(): Metoda ta powinna czyścić listę sprawdzanych biletów, usuwając wszystkie
zapisane bilety. 
*/

namespace L6
{
    using System;
    using System.Collections.Generic;
    using System.Text;
    using System.Linq;

    class Employee
    {
        public int Id { get; }
        public string FirstName { get; }
        public string LastName { get; }
        public string Position { get; }

        public Employee(int id, string firstName, string lastName, string position)
        {
            Id = id;
            FirstName = firstName;
            LastName = lastName;
            Position = position;
        }

        public override string ToString()
        {
            return $"{Id}: {FirstName} {LastName}, Position: {Position}";
        }
    }

    interface IEmployeeDatabase
    {
        void AddEmployee(int id, string firstName, string lastName, string position);
        void RemoveEmployee(int id);
        Employee GetEmployee(int id);
    }

    class EmployeeDatabase : IEmployeeDatabase
    {
        private Dictionary<int, Employee> employees = new Dictionary<int, Employee>();

        public void AddEmployee(int id, string firstName, string lastName, string position)
        {
            if (employees.ContainsKey(id))
                throw new InvalidOperationException("Employee with this ID already exists.");

            var employee = new Employee(id, firstName, lastName, position);
            employees[id] = employee;
        }

        public void RemoveEmployee(int id)
        {
            if (!employees.ContainsKey(id))
                throw new KeyNotFoundException("Employee not found.");

            employees.Remove(id);
        }

        public Employee GetEmployee(int id)
        {
            if (!employees.TryGetValue(id, out var employee))
                throw new KeyNotFoundException("Employee not found.");

            return employee;
        }
    }

    class OrderManagementSystem
    {
        private HashSet<(int orderId, string customerName)> orders = new HashSet<(int, string)>();

        public void PlaceOrder(int orderId, string customerName)
        {
            if (!orders.Add((orderId, customerName)))
                throw new InvalidOperationException("Order with this ID already exists.");
        }

        public void CancelOrder(int orderId)
        {
            var orderToRemove = orders.FirstOrDefault(o => o.orderId == orderId);
            if (orderToRemove.Equals(default((int, string))))
                throw new KeyNotFoundException("Order not found.");

            orders.Remove(orderToRemove);
        }

        public void DisplayOrders()
        {
            foreach (var order in orders)
            {
                Console.WriteLine($"Order ID: {order.orderId}, Customer: {order.customerName}");
            }
        }

        public int TotalOrders()
        {
            return orders.Count;
        }
    }

    class TicketChecker
    {
        private HashSet<string> tickets = new HashSet<string>();

        public void AddTicket(string ticketCode)
        {
            if (!tickets.Add(ticketCode))
                throw new InvalidOperationException("Ticket already exists.");
        }

        public bool CheckTicket(string ticketCode)
        {
            return tickets.Contains(ticketCode);
        }

        public void ClearTickets()
        {
            tickets.Clear();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            IEmployeeDatabase employeeDb = new EmployeeDatabase();
            employeeDb.AddEmployee(1, "John", "Doe", "Developer");
            employeeDb.AddEmployee(2, "Jane", "Smith", "Manager");

            Console.WriteLine(employeeDb.GetEmployee(1));
            employeeDb.RemoveEmployee(2);

            var orderSystem = new OrderManagementSystem();
            orderSystem.PlaceOrder(101, "Alice");
            orderSystem.PlaceOrder(102, "Bob");
            orderSystem.DisplayOrders();
            Console.WriteLine($"Total Orders: {orderSystem.TotalOrders()}");

            var ticketChecker = new TicketChecker();
            ticketChecker.AddTicket("TICKET123");
            Console.WriteLine(ticketChecker.CheckTicket("TICKET123")); // True
            ticketChecker.ClearTickets();
        }
    }
}