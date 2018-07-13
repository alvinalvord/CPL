#include <cstdio>
#include <cstring>

int
main ()
{
	char arr[101];

	scanf ("%s", arr);
	
	int len = strlen (arr);
	bool flag = true;
	for (int i = 0; i < len; i++) {
		if (
			arr[i] != 'a' &&
			arr[i] != 'i' &&
			arr[i] != 'u' &&
			arr[i] != 'e' &&
			arr[i] != 'o' &&
			arr[i] != 'n'
			) {
				if (i + 1 == len) {
					flag = false;
					break;
				}
				if (
					arr[i + 1] != 'a' &&
					arr[i + 1] != 'i' &&
					arr[i + 1] != 'u' &&
					arr[i + 1] != 'e' &&
					arr[i + 1] != 'o'
					) {
						flag = false;
						break;
					}
				
			}
	}
	
	printf ("%s\n", (flag ? "YES": "NO"));
	
	
	
	return 0;
}
