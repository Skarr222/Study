#include <iostream>
#include <fstream>
#include <cstdlib>

int main(int argc, char *argv[])
{
    char c;
    int mov = std::stoi(argv[1]);
    if (mov > 26 || mov < -26)
    {
        mov %= 26;
    }
    std::ifstream input(argv[2]);
    std::ofstream output(argv[3]);

    while (input.get(c))
    {
        if (c >= 65 && c <= 90)
        {
            if (int(c + mov) > 90)
            {
                output << char(c + mov - 26);
            }
            else
            {
                if (int(c + mov) < 65)
                {
                    output << char(c + mov + 26);
                }
                else
                    output << char(c + mov);
            }
        }
        else
        {
            if (c >= 97 && c <= 122)
            {
                if (int(c + mov) > 122)
                {
                    output << char(c + mov - 26);
                }
                else
                {
                    if (int(c + mov) < 97)
                    {
                        output << char(c + mov + 26);
                    }
                    else
                        output << char(c + mov);
                }
            }
            else
                output << c;
        }
    }

    input.close();
    output.close();
}
