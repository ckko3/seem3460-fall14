#include <stdio.h>
#include <string.h>
#include "functions.h"

int main() 
{
	char str1[100]; 		/* buffer to hold input string	  */
	char str1rev[100]; 		/* buffer to hold transformed string	  */

	input(str1);
	CaseConversion(str1,str1rev);
	printf("The case conversion of %s is %s.\n",str1,str1rev);
	return 0;
}
