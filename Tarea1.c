#include <stdio.h>
#include <stdlib.h>

int main(){
    int  i;
    float nota1,nota2,nota3;

    printf("Nota: ");
    scanf("%f",&nota1);
    
    printf("Nota: ");
    scanf("%f",&nota2);
    
    printf("Nota: ");
    scanf("%f",&nota3);
    
    
    printf("El promedio es: %.3f\n",(nota1*0.4 + nota2*0.3 + nota3*0.3)/3.0);


    system("pause");
    return 0;
}