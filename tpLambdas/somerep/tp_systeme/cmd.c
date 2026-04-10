#include<stdlib.h>
#include<stdio.h>
#include<string.h>

int main(int argc, char* argv[]) {
	FILE* fp;
	if (argc < 2) {
		fprintf(stderr, "usage: %s <file_name>\n", argv[0]);
	} else {
		fp=fopen(argv[1], "r");
		if (fp==NULL) {
			fprintf(stderr, "%s unreachable\n", argv[1]);
		} else {
			char command[256];
			strcpy(command,"ls -loTF ");
			strcat(command, argv[1]);
			system(command);
		}	
	}
}
