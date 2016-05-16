#include <stdio.h>
#include "display.h"
#include <time.h>

int card[12];
int J,Q,K=0;

int check_balance(int x){
	if(x<4){
		if(J==2)return 0;
		else return 1;
	}
	else if(x>7){
		if(K==2)return 0;
		else return 1;
	}
	else{
		if(Q==2)return 0;
		else return 1;
	}
}

void card_function1() {
	int a=0;
	int x;
	display_card_clear();
	while(a<6){
		x=rand()%12;
		if(x%2==a%2){
			if(card[x]==1 && check_balance(x)==1){
				display_card(a,x);
				card[x]=0;
				if(x<4)J++;
				else if(x>7)K++;
				else Q++;
				a++;
			}
		}
	}
	move_card_set(120,40);
}

void card_function2() {
	int a=0;
	int x;
	display_card_clear();
	while(a<5){
		x=rand()%12;
		if(x%2==a%2){
			if(card[x]==1){
				display_card(a,x);
				card[x]=0;
				a++;
			}
		}
	}
	move_card_set(120,40);
}


int main(int argc, char *argv[]) {
	int i,z;
	for(z=0;z<12;z++)card[z]=1;
	init_display(&argc, argv);
	for (i=0;i<11;i++) {
		switch(i){
			case 0:display_text("In a moment, you will enter a magical world...",50,100,16);break;
			case 1:display_text("In a little while ...",50,100,16);break;
			case 2:display_text("In a little while you will witness something very special ...",50,100,16);break;
			case 3:display_text("... you will witness ...",50,100,16);break;
			case 4:display_text("An amazing illusion ...",50,100,16);break;
			case 5:display_text("... the illusion of David Copperfield",50,100,16);wait_time(2);display_david(0,0);break;
			case 6:display_text("Although this is an ordinary program, you will see that",50,100,16);break;
			case 7:display_text("I can, via your computer, tell you what you have been thinking",50,100,16);break;
			case 8:display_text("In front of you are 6 different cards.\nThink of one.\nJust think.",50,100,16);card_function1();break;
			case 9:display_text("Don't \"click\" on it.\nI will find the card in your thoughts.\nThink now.",50,100,16);break;
			case 10:display_text("Don't \"click\" on it.\nI will find the card in your thoughts.\nThink now.\n<i>Press Continue</i>",50,100,16);break;
		}
		wait_time(3);
	}
	wait_for_a_click();
	return 0;
}

void action_on_click() {
	int i;
	for (i=0;i<7;i++) {
		switch(i){
			case 0:display_text("Now look into my eyes\nThink of your card\nthe whole time ...",50,100,16);display_david(0,0);break;
			case 1:display_text("I don't know you\nand I couldn't see you chose ...",50,100,16);break;
			case 2:display_text("... but I will show\nthe card you thought of",50,100,16);break;
			case 3:display_text("Look",50,100,20);card_function2();break;
			case 4:display_text("Look\nI took your card!!",50,100,20);break;
			case 5:display_text("I have shown you\nwhich card you chose",50,100,16);break;
			case 6:display_text("See you!",50,100,16);break;
		}
		wait_time(3);
	}
	exit_display();
}

