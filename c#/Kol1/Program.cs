using System;
using System.Collections.Generic;
using System.Linq;


namespace Kol1
{

    public interface IProduct
    {
        string Name { get; }
        decimal Price { get; }
    }

    public interface ICart
    {
        void AddProduct(IProduct product);
        void RemoveProduct(IProduct product);
        decimal CalculateTotal();
    }

    public class Product : IProduct
    {
        public string Name { get; }
        public decimal Price { get; }

        public Product(string name, decimal price)
        {
            Name = name;
            Price = price;
        }

        public override string ToString() => $"{Name} - {Price:C}";
    }

    public class Cart : ICart
    {
        private List<IProduct> products = new List<IProduct>();

        public void AddProduct(IProduct product)
        {
            products.Add(product);
        }

        public void RemoveProduct(IProduct product)
        {
            products.Remove(product);
        }

        public decimal CalculateTotal()
        {
            return products.Sum(p => p.Price);
        }

        public void ShowCart()
        {
            Console.WriteLine("Zawartość koszyka:");
            foreach (var product in products)
            {
                Console.WriteLine(product);
            }
        }

        public static Cart operator +(Cart cart, IProduct product)
        {
            cart.AddProduct(product);
            return cart;
        }

        public static Cart operator -(Cart cart, IProduct product)
        {
            cart.RemoveProduct(product);
            return cart;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            // Tworzenie produktów
            Product p1 = new Product("Komputer", 3200);
            Product p2 = new Product("Myszka", 250);
            Product p3 = new Product("Klawiatura", 450);

            Cart cart = new Cart();

            cart.AddProduct(p1);
            cart.AddProduct(p2);
            cart.ShowCart();
            Console.WriteLine($"Całkowita wartość koszyka: {cart.CalculateTotal():C}\n");

            cart.RemoveProduct(p1);
            cart.ShowCart();
            Console.WriteLine($"Całkowita wartość koszyka: {cart.CalculateTotal():C}\n");

            cart = cart + p1 + p3;
            cart.ShowCart();
            Console.WriteLine($"Całkowita wartość koszyka: {cart.CalculateTotal():C}\n");

            cart = cart - p2;
            cart.ShowCart();
            Console.WriteLine($"Całkowita wartość koszyka: {cart.CalculateTotal():C}\n");

            cart.ShowCart();
            Console.WriteLine($"Całkowita wartość koszyka: {cart.CalculateTotal():C}\n");

        }
    }
}

// static class Kalkulator
// {
//     public static int LiczbaWywolanDodaj { get; private set; } = 0;
//     public static int LiczbaWywolanOdejmij { get; private set; } = 0;

//     public static double Dodaj(double a, double b)
//     {
//         LiczbaWywolanDodaj++;
//         return a + b;
//     }

//     public static double Odejmij(double a, double b)
//     {
//         LiczbaWywolanOdejmij++;
//         return a - b;
//     }
// }

// class User
// {
//     public string Login { get; set; }
//     public string Password { get; set; }

//     public User(string login, string password)
//     {
//         Login = login;
//         Password = password;
//     }

//     public virtual void GetInfo()
//     {
//         Console.WriteLine($"Login: {Login}");
//     }
// }

// class Administrator : User
// {
//     public int AccessLevel { get; set; }

//     public Administrator(string login, string password, int accessLevel)
//         : base(login, password)
//     {
//         AccessLevel = accessLevel;
//     }

//     public override void GetInfo()
//     {
//         base.GetInfo();
//         Console.WriteLine($"Access Level: {AccessLevel}");
//     }
// }

// class Moderator : User
// {
//     public List<string> GrantedModules { get; set; }

//     public Moderator(string login, string password, List<string> grantedModules)
//         : base(login, password)
//     {
//         GrantedModules = grantedModules;
//     }

//     public override void GetInfo()
//     {
//         base.GetInfo();
//         Console.WriteLine("Granted Modules: " + string.Join(", ", GrantedModules));
//     }
// }

// class RegularUser : User
// {
//     public RegularUser(string login, string password)
//         : base(login, password) { }

//     public override void GetInfo()
//     {
//         base.GetInfo();
//         Console.WriteLine("User Type: Regular User");
//     }
// }