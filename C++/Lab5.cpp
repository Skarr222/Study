#include <iostream>
#include <string>

int main()
{
    std::string s;

    while (std::getline(std::cin, s))
    {
        int j = s.find_first_not_of(" \t");
        /*
      for (int i = 0; i < s.size(); ++i)
      {
          if (s[i] != ' ' && s[i] != '\t')
          {
              j = i;
          }
      }
      */
        std::cout << j << std::endl;
        std::cout << s << "|" << std::endl;
    }
}