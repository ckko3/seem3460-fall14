#include <stdio.h>
#include <string.h>
#include "functions.h"

void input(char *str1)
{
	int notAlphabet = 1;
	while(notAlphabet)
	{
		notAlphabet = 0;
		printf("Input the String:");
		scanf("%s", str1);		

		int i, len;
		len = strlen(str1);
		for(i = 0; i < len; i ++)
		{
			if((str1[i]<=122 && str1[i]>=97) ||(str1[i]<=90 && str1[i]>=65))
				continue;
			else
			{
				printf("Input Failure! All the chars should be a-z or A-Z and contains no space\n");
				notAlphabet = 1;
				break;
			}
		}
	}
}

void CaseConversion(char* before, char* after)
{
	do{
		if(*before<=122 && *before >= 97)
			*(after++) = (*before) - 32;
		else if(*before<=90 && *before>=65)
			*(after++) = (*before) + 32;
	}while(*(++before));
	*after = *before;
	return;
}
