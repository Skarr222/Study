#include <iostream>
#include <string>
#include <sstream>

int main()
{
    for (std::string line; std::getline(std::cin, line);)
    {
        std::string word;
        for (std::isstringstream stream(line); stream >> word;)
        {
            std::cout << word << " ";
        }
        std::cout << word << std::endl;
    }
}
