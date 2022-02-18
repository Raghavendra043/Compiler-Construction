#include <stdio.h>
#include <string.h>

int main()
{
    char Str[1000];
    char arr[1000];
    int i,j,a,b,k=0;
    scanf("%s", Str);
    for (i = 0; Str[i] != '\0'; ++i);
    for (j = 0; Str[j] !='"'; ++j);
    for (a = j+1; Str[a] != '"'; ++a);
    b = a - j - 1;
    for (int z = 0; z < b; z++){
        arr[z] = Str[j+1];
        printf("%c",arr[z]);
        j++;
    }
}