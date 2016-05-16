#define MAX_CARD_TO_HOLD 6

void init_display(int *argc, char *argv[]);
void display_text(char *message, int x, int y, int size);
void display_card(int position, int card_id);
void display_david(int x, int y);
void display_card_clear();
void move_card_set(int x, int y);
void wait_for_a_click();
void exit_display();
void wait_time(double seconds);
