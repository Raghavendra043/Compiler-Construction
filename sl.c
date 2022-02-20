#include <stdio.h>
#include <string.h>

int main()
{
    char Str[1000];
    int i,j;
    scanf("%s", Str);
    for (i = 0; Str[i] != '\0'; ++i);
    for (j = 0; j < i; j++){
        if(Str[j] == '"'){
            j++;
            goto there;

        }
    }
    return 0;
    there:
    for (j ; j < i; j++){
        if(Str[j] == '\\'){
                j++;
            if(Str[j] == '\\' || '"' || 't' || 'n' || 'r'){
                return 1;


            }
             else{
                return 0;
                break;
            }

        }
        if(Str[j] == '"'){
           return 1;
           break;

        }
    }

}
