#include <iostream>

int main(){
    int a=1, b=2,n;

    std::cin>>n;
    for(int i=1; i<=n;i++){

        std::cout<<a<<"";
        b+=a;
        a=b-a;
    }
}
