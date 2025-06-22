/*
1. Zaprojektuj funkcjonalność, która umożliwi filtrowanie listy zadań na podstawie różnych
kryteriów. W tym celu wykorzystamy delegat Func. Zdefiniuj klasę Zadanie z następującymi
polami:
• Tytuł (typ string) - przechowuje tytuł zadania
• Priorytet (typ int) - przechowuje priorytet zadania (np. 1 - niski, 2 - średni, 3 - wysoki)
• Termin (typ DateTime) - przechowuje termin wykonania zadania
Stwórz klasę ZarządzanieZadaniami, która będzie zawierała metodę FiltrujZadania. Ta metoda
powinna przyjmować listę zadań oraz delegat Func jako argumenty i zwracać nową listę zadań
spełniających określone kryteria.
W metodzie FiltrujZadania wykorzystaj przekazany delegat Func, aby sprawdzić, które zadania
powinny zostać uwzględnione w wynikowej liście. Delegat powinien przyjmować obiekt typu Zadanie
i zwracać wartość logiczną, czy zadanie spełnia określone kryteria.
Przetestuj funkcjonalność klasy ZarządzanieZadaniami i delegatu Func, tworząc kilka obiektów klasy
Zadanie i przekazując je do metody FiltrujZadania z odpowiednimi delegatami do filtrowania zadań.
• Zaimplementuj klasę Zadanie z odpowiednimi polami i konstruktorem.
• Zaimplementuj klasę ZarządzanieZadaniami z metodą FiltrujZadania, która przyjmuje listę
zadań oraz delegat Func i zwraca nową listę zadań spełniających określone kryteria.
• Przetestuj funkcjonalność klasy ZarządzanieZadaniami, tworząc kilka obiektów klasy Zadanie
i przekazując je do metody FiltrujZadania z odpowiednimi delegatami do filtrowania zadań.
Wyświetl wyniki na konsoli.
2. Stwórz własny wyjątek oraz zaimplementuj jego użycie w odpowiedniej sytuacji.
Zdefiniuj klasę Pracownik z następującymi polami:
• Imie (typ string) - przechowuje imię pracownika
• Nazwisko (typ string) - przechowuje nazwisko pracownika
• Wiek (typ int) - przechowuje wiek pracownika
Stwórz klasę ZarządzaniePracownikami, która będzie zawierała metodę DodajPracownika. Ta metoda
powinna przyjmować obiekt typu Pracownik i sprawdzać, czy pracownik spełnia określone warunki.
Jeśli warunki nie są spełnione, powinien być zgłaszany własny wyjątek.
Stwórz własny wyjątek o nazwie NiedozwolonyPracownikException. Ten wyjątek powinien
dziedziczyć po klasie Exception i zawierać odpowiednie konstruktory.
Obsłuż wyjątek NiedozwolonyPracownikException w metodzie DodajPracownika klasy
ZarządzaniePracownikami. Jeśli wyjątek zostanie zgłoszony, wyświetl odpowiedni komunikat na
konsoli.
• Zaimplementuj klasę Pracownik z odpowiednimi polami i konstruktorem.
• Zaimplementuj klasę ZarządzaniePracownikami z metodą DodajPracownika, która przyjmuje
obiekt typu Pracownik i sprawdza, czy pracownik spełnia określone warunki.
• Zdefiniuj własny wyjątek NiedozwolonyPracownikException, dziedziczący po klasie
Exception, i dodaj odpowiednie konstruktory.
• Obsłuż wyjątek NiedozwolonyPracownikException w metodzie DodajPracownika klasy
ZarządzaniePracownikami. Wyświetl odpowiedni komunikat na konsoli w przypadku
zgłoszenia wyjątku.
*/

namespace L7
{
    using System;
    using System.Collections.Generic;
    using System.Text;
    

    class Task
    {
        public string Title { get; set; }
        public int Priority { get; set; }
        public DateTime Deadline { get; set; }

        public Task(string title, int priority, DateTime deadline)
        {
            Title = title;
            Priority = priority;
            Deadline = deadline;
        }
    }

    class TaskManagement
    {
        public List<Task> FilterTasks(List<Task> tasks, Func<Task, bool> criteria)
        {
            return tasks.FindAll(new Predicate<Task>(criteria));
        }
    }



    class Employee
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public int Age { get; set; }

        public Employee(string firstName, string lastName, int age)
        {
            FirstName = firstName;
            LastName = lastName;
            Age = age;
        }
    }
    interface IEmployeeManagement
    {
        void AddEmployee(Employee employee);
    }

    class EmployeeManagement : IEmployeeManagement
    {

        public void AddEmployee(Employee employee)
        {
            if (employee.Age < 18 || string.IsNullOrEmpty(employee.FirstName) || string.IsNullOrEmpty(employee.LastName) || employee.Age > 65)
            {
                throw new InvalidEmployeeException("Invalid employee data.");
            }
            else
            {
                Console.WriteLine($"Employee {employee.FirstName} {employee.LastName} added successfully.");
            }

        }
    }

    class InvalidEmployeeException(string message) : Exception(message)
    {
    }

    class Program
    {
        static void Main(string[] args)
        {
            // Task Management Example
            TaskManagement taskManagement = new TaskManagement();
            List<Task> tasks = new List<Task>
            {
                new Task("Task 1", 1, DateTime.Now.AddDays(1)),
                new Task("Task 2", 2, DateTime.Now.AddDays(2)),
                new Task("Task 3", 3, DateTime.Now.AddDays(3))
            };
            Func<Task, bool> highPriorityCriteria = task => task.Priority == 3;
            List<Task> highPriorityTasks = taskManagement.FilterTasks(tasks, highPriorityCriteria);
            Console.WriteLine("High Priority Tasks:");
            foreach (var task in highPriorityTasks)
            {
                Console.WriteLine($"- {task.Title} (Priority: {task.Priority}, Deadline: {task.Deadline})");
            }
            // Employee Management Example
            EmployeeManagement employeeManagement = new EmployeeManagement();
            try
            {
                Employee employee1 = new Employee("John", "Doe", 25);
                employeeManagement.AddEmployee(employee1);

                Employee employee2 = new Employee("Jane", "Smith", 17); // Invalid age
                employeeManagement.AddEmployee(employee2);
            }
            catch (InvalidEmployeeException ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
            try
            {
                Employee employee3 = new Employee("Alice", "Johnson", 70); // Invalid age
                employeeManagement.AddEmployee(employee3);
            }
            catch (InvalidEmployeeException ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
            try
            {
                Employee employee4 = new Employee("", "Brown", 30); // Invalid first name
                employeeManagement.AddEmployee(employee4);
            }
            catch (InvalidEmployeeException ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
            try
            {
                Employee employee5 = new Employee("Charlie", "", 30); // Invalid last name
                employeeManagement.AddEmployee(employee5);

            }
            catch (InvalidEmployeeException ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }

        }
    }
}