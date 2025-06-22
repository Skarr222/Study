/*
* 1. Napisz klasę o nazwie "Matrix", która reprezentuje macierz kwadratową. Zaimplementuj
* przeciążenie operatora indeksowania dla tej klasy, aby można było odczytywać i
* modyfikować wartości w macierzy za pomocą indeksów. Przeciąż operator dodawania dla
* macierzy, tak aby możliwe było dodawanie dwóch macierzy o tych samych rozmiarach.
* Przetestuj działanie tych operatorów, tworząc obiekty klasy "Matrix" i wykorzystując
* operatory do wykonywania operacji na macierzach. Napisz również przeciążenie metody
* ToString tak aby wyświetlała zawartość macierzy.
* 2. Napisz strukturę o nazwie "Point3D", która reprezentuje punkt w trójwymiarowej
* przestrzeni. Struktura powinna przechowywać współrzędne x, y i z. Dodaj metodę o nazwie
* "Translate", która przyjmuje trzy argumenty typu int (przesunięcie dla każdej współrzędnej) i
* przesuwa punkt o podane wartości. Następnie napisz program, który tworzy obiekt
* "Point3D", wywołuje metodę "Translate" i wyświetla nowe współrzędne punktu po
* przesunięciu.
* 3. Napisz program, który wymaga zaprojektowania klasy, która będzie zachowywać się jak
* struktura pod względem logiki równości struktur. Klasa ta powinna przechowywać
* informacje o osobie, takie jak imię, nazwisko i wiek. Klasa powinna porównywać obiekty na
* podstawie wartości pól (imię, nazwisko i wiek) i zwracać true, jeśli te wartości są takie same
* dla obu obiektów. Dodatkowo, klasa powinna przesłaniać metodę Equals, aby zapewnić
* poprawne porównywanie obiektów.
*/



namespace L5
{

    class Matrix
    {
        private int[,] matrix;

        public Matrix(int size)
        {
            matrix = new int[size, size];
        }

        public int this[int row, int col]
        {
            get => matrix[row, col];
            set => matrix[row, col] = value;
        }

        public static Matrix operator +(Matrix a, Matrix b)
        {
            if (a.matrix.GetLength(0) != b.matrix.GetLength(0))
                throw new InvalidOperationException("Matrices must be of the same size.");

            int size = a.matrix.GetLength(0);
            Matrix result = new Matrix(size);

            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    result[i, j] = a[i, j] + b[i, j];

            return result;
        }

        public override string ToString()
        {
            var sb = new StringBuilder();
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    sb.Append(matrix[i, j] + " ");
                }
                sb.AppendLine();
            }
            return sb.ToString();
        }
    }
    struct Point3D
    {
        public int X { get; private set; }
        public int Y { get; private set; }
        public int Z { get; private set; }

        public Point3D(int x, int y, int z)
        {
            X = x;
            Y = y;
            Z = z;
        }

        public void Translate(int dx, int dy, int dz)
        {
            X += dx;
            Y += dy;
            Z += dz;
        }

        public override string ToString()
        {
            return $"Point3D({X}, {Y}, {Z})";
        }

    }

    class Program
    {
        static void Main(string[] args)
        {
            Matrix matrix1 = new Matrix(2);
            matrix1[0, 0] = 1;
            matrix1[0, 1] = 2;
            matrix1[1, 0] = 3;
            matrix1[1, 1] = 4;
            Matrix matrix2 = new Matrix(2);
            matrix2[0, 0] = 5;
            matrix2[0, 1] = 6;
            matrix2[1, 0] = 7;
            matrix2[1, 1] = 8;
            Matrix resultMatrix = matrix1 + matrix2;
            Console.WriteLine("Resulting Matrix:");
            Console.WriteLine(resultMatrix);


            // Test Point3D struct
            Point3D point = new Point3D(1, 2, 3);
            Console.WriteLine("Original Point: " + point);
            point.Translate(1, -1, 2);
            Console.WriteLine("Translated Point: " + point);

        }
    }

}

