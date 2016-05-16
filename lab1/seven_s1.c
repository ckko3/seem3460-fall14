#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int data[6];		/* the parsed input stored in array */
	int four_count;		/* number of fours in the input data */
	int seven_count;        /* number of sevens in the input data */
} Data;

char line[100];         	/* line of input */
int i;				/* for-loop index */
Data* data;			/* store the input data and counts in the structure */

void get_data(Data* data);

int main() {
	data = (Data*)malloc(sizeof(Data));
	data->four_count = 0;
	data->seven_count = 0;

	get_data(data);

	for (i=1; i<=5; i++) {
		if (data->data[i] == 4) data->four_count++;
                if (data->data[i] == 7) data->seven_count++;
	}	

	printf("%d Fours %d Sevens\n", data->four_count, data->seven_count);
	/*The above line is a printf statement, where the error is missing the terminating character ", because string must be enclosed by double quotes.*/
	return 0;
}

void get_data(Data* data) {
	printf("Enter 5 numbers:\n");
	fgets(line, sizeof(line), stdin);
	sscanf(line, "%d %d %d %d %d",
		&data->data[1], &data->data[2], &data->data[3], &data->data[4], &data->data[5]);
}

