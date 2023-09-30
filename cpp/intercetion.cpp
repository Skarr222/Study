#include <iostream>
#include <vector>

std::vector<int> intersection(const std::vector<int> &vecx, const std::vector<int> &vecy){
std::vector<int> wynik;
for(size_t x=0, y=0;(x<vecx.size())&&(y<vecy.size());++x,++y){
        if(vecx[x]<vecy[y]) {
            --y;
        } else if (vecx[x]>vecy[y]) {
            --x;
        } else {
            wynik.push_back(vecx[x]);
        };
    }

    return wynik;
}

int main(){
    const std::vector<int> vector1{-7,  2, 3, 7, 15, 18,23};
    const std::vector<int> vector2{-8, 3, 5, 8, 15, 23, 30};

    std::vector<int> result = intersection(vector1, vector2);

    for (int element: result) {
        std::cout<< element << " ";
    }

    std::cout << std::endl;
}
