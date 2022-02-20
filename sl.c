#include <stdio.h>
#include <string.h>

int main()
{
    char Str[1000];
    int i,j;
    scanf("%s", Str);
    for (i = 0; Str[i] != '\0'; ++i);
        if(Str[0] == '"'){
            goto there;

        }
        else{
              return 0;
        }

    there:
    for (j=1 ; j < i; j++){
            if(Str[j] == ' '){
                continue;
            }
        if(Str[j] == '\\'){
                j++;
            if(Str[j] == '\\'){
                continue;
            }
            else if(Str[j] == '"'){
                continue;
            }
            else if(Str[j] == 't'){
                continue;
            }
            else if(Str[j] == 'n'){
                continue;

            }
            else if(Str[j] == 'r'){
                continue;
            }
             else{
                return 0;
                break;
            }

        }
        if(Str[j] == '"'){
                if(j = i - 1){
                    return 1;
                }
                else{
                    return 0;
                }

           break;
        }
    }

}
