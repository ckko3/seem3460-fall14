#include <stdio.h>
#include "display.h"
#include <time.h>

int main(int argc, char *argv[]) {
	int i;
   time_t t;
	char temptext[1000];
	srand((unsigned)time(&t));
	init_display(&argc, argv);
	for (i=0;i<5;i++) {
		wait_time(0.1);
		sprintf(temptext,"%d seconds",i+1);
		display_text(temptext,i*10,100,20);
		display_card_clear();
		if (i%3!=0) {
			display_card(0,0);
			display_card(0,1);
			display_card(1,11);
			display_card(1,11);
			display_card(2,11);
			display_card(3,11);
		}
		move_card_set(0,0);
		wait_time(0.1);
	}
	display_david(0,0);
	wait_for_a_click();
	return 0;
}

void action_on_click() {
	int i;
	char temptext[1000];
	for (i=5;i<10;i++) {
		wait_time(0.1);
		sprintf(temptext,"%d seconds",i+1);
		display_text(temptext,i*10,100,20);
		display_card_clear();
		if (i%4!=0) {
			display_card(0,rand()%11);
			display_card(rand()%6,rand()%11);
		}
		move_card_set(0,0);
		wait_time(0.1);
	}
	exit_display();
}
