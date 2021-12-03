//#include <iostream>

//using namespace std;

//Test cpp file

//int main(){
    //cout << "Hello World!";

    //Next 4 lines of code are duplicates, first refactoring
    int a = 4;
    int b = 5;
    int c = 3;
    int d = 8;

    int x, y;

    //Next 2 if statements are duplicates, second refactoring
    if(a < b)
        x = a + b;

    if(c < d)
        y = c + d;

    return 0;
}
